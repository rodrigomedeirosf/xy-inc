package br.com.xy.poi.business.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.xy.poi.business.model.Poi;
import br.com.xy.poi.business.service.impl.PoiService;
import br.com.xy.poi.model.repository.IPoiRepository;

@RunWith(MockitoJUnitRunner.class)
public class PoiServiceTest {
	
	@Mock
	IPoiRepository poiRepository;
	
	IPoiService poiService;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		poiService = new PoiService(poiRepository);
	}
	
	@Test
	public void saveTest(){
		br.com.xy.poi.model.entity.Poi poiSaved = new br.com.xy.poi.model.entity.Poi(1, "Po1", 10, 20);
		when(poiRepository.save(Mockito.any(br.com.xy.poi.model.entity.Poi.class))).thenReturn(poiSaved);
		
		Poi poi = poiService.save(new Poi());
		Assert.assertEquals(poiSaved.getId(), poi.getId());
		Assert.assertEquals(poiSaved.getName(), poi.getName());
		Assert.assertEquals(poiSaved.getX(), poi.getX());
		Assert.assertEquals(poiSaved.getY(), poi.getY());
	}
	
	@Test
	public void listAllTest(){
		List<br.com.xy.poi.model.entity.Poi> resultList = new ArrayList<br.com.xy.poi.model.entity.Poi>();
		resultList.add(new br.com.xy.poi.model.entity.Poi(1, "Po1", 10, 20));
		resultList.add(new br.com.xy.poi.model.entity.Poi(2, "Po2", 12, 31));
		when(poiRepository.listAll()).thenReturn(resultList);
		
		List<Poi> result = poiService.listAll();
		for(int i=0; i<result.size(); i++){
			Poi poi = result.get(i);
			br.com.xy.poi.model.entity.Poi entityPoi = resultList.get(i);
			Assert.assertEquals(entityPoi.getId(), poi.getId());
			Assert.assertEquals(entityPoi.getName(), poi.getName());
			Assert.assertEquals(entityPoi.getX(), poi.getX());
			Assert.assertEquals(entityPoi.getY(), poi.getY());
			
		}
		
	}
	
	@Test
	public void searchByQuadrantPointsTest(){
		List<br.com.xy.poi.model.entity.Poi> resultList = new ArrayList<br.com.xy.poi.model.entity.Poi>();
		resultList.add(new br.com.xy.poi.model.entity.Poi(1, "Lanchonete", 27, 12));
		resultList.add(new br.com.xy.poi.model.entity.Poi(2, "Joalheria", 15, 12));
		resultList.add(new br.com.xy.poi.model.entity.Poi(2, "Pub", 12, 8));
		resultList.add(new br.com.xy.poi.model.entity.Poi(2, "Supermercado", 23, 6));
		resultList.add(new br.com.xy.poi.model.entity.Poi(2, "Churrascaria", 28, 2));
		when(poiRepository.searchByQuadrantPoints(10, 0, 30, 20)).thenReturn(resultList);
		
		List<Poi> poiList = poiService.findByDistance(20, 10, 10);
		List<String> expectedPois = new ArrayList<String>(Arrays.asList("Lanchonete", "Joalheria", "Pub", "Supermercado"));
		for(Poi poi: poiList){
			Assert.assertTrue(expectedPois.contains(poi.getName()));
			expectedPois.remove(poi.getName());
		}
		Assert.assertTrue(expectedPois.isEmpty());
	}
	
}
