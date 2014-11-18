package br.com.xy.poi.model.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.xy.poi.model.entity.Poi;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:poi-repository-context-test.xml")
@Transactional
public class PoiRepositoryTest {

	@Autowired
	private IPoiRepository poiRepository;
	
	@Test
	public void listAllPois(){
		
		List<Poi> poiList = poiRepository.listAll();
		
		Assert.assertNotNull(poiList);
		Assert.assertFalse(poiList.isEmpty());
	}
	
	@Test
	@Transactional(propagation=Propagation.REQUIRED)
	public void savePoi(){
		
		Poi poiZup = new Poi();
		poiZup.setName("Zup");
		poiZup.setX(45);
		poiZup.setY(20);
		
		poiRepository.save(poiZup);
		
		Assert.assertNotNull(poiZup);
		Assert.assertNotNull(poiZup.getId());
		Assert.assertTrue(poiZup.getId() > 0);
	}
	
	@Test
	public void searchByQuadrantPoints(){
		
		List<String> expectedPois = new ArrayList<String>(Arrays.asList("Lanchonete", "Joalheria", "Pub", "Supermercado", "Churrascaria"));
		List<Poi> poiList = poiRepository.searchByQuadrantPoints(10, 0, 30, 20);
		Assert.assertNotNull(poiList);
		for(Poi poi: poiList){
			Assert.assertTrue(expectedPois.contains(poi.getName()));
			expectedPois.remove(poi.getName());
		}
		Assert.assertTrue(expectedPois.isEmpty());
	}
	
}
