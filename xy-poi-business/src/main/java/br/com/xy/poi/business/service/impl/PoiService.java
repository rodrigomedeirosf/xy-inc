package br.com.xy.poi.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.xy.poi.business.model.Poi;
import br.com.xy.poi.business.service.IPoiService;
import br.com.xy.poi.business.util.predicate.PoiDistancePredicate;
import br.com.xy.poi.model.repository.IPoiRepository;

@Service
public class PoiService implements IPoiService {
	
	IPoiRepository poiRepository;
	
	@Autowired
	public PoiService(IPoiRepository poiRepository){
		this.poiRepository = poiRepository;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Poi save(Poi poi) {
		br.com.xy.poi.model.entity.Poi poiEntity = new br.com.xy.poi.model.entity.Poi();
		BeanUtils.copyProperties(poi, poiEntity);
		return toPoiModel(poiRepository.save(poiEntity));
	}

	@Override
	@Transactional
	public List<Poi> listAll() {
		return toPoiModel(poiRepository.listAll());
	}

	@Override
	@Transactional
	public List<Poi> findByDistance(Integer coordinateX, Integer coordinateY,
			Integer distance) {

		List<Poi> searchResult = toPoiModel(poiRepository
				.searchByQuadrantPoints(
						(int) Math.max(0, coordinateX - distance),
						(int) Math.max(0, coordinateY - distance), 
						coordinateX + distance, 
						coordinateY + distance));

		CollectionUtils.filter(searchResult, new PoiDistancePredicate(coordinateX, coordinateY, distance));
		return searchResult;
	}
	
	private Poi toPoiModel(br.com.xy.poi.model.entity.Poi poi) {
		try{
			Poi result = new Poi();
			BeanUtils.copyProperties(poi, result);
			return result;
		}catch(IllegalArgumentException e){
			return null;
		}
	}

	private List<Poi> toPoiModel(List<br.com.xy.poi.model.entity.Poi> poiList) {
		try{
			List<Poi> result = new ArrayList<Poi>();
			for (br.com.xy.poi.model.entity.Poi poi : poiList) {
				Poi poiModel = new Poi();
				BeanUtils.copyProperties(poi, poiModel);
				result.add(poiModel);
			}
			return result;
		}catch(IllegalArgumentException e){
			return null;
		}
	}

}
