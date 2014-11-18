package br.com.xy.poi.business.service;

import java.util.List;

import br.com.xy.poi.business.model.Poi;

public interface IPoiService {
	
	Poi save(Poi poi);
	
	List<Poi> listAll();
	
	List<Poi> findByDistance(Integer coordinateX, Integer coordinateY, Integer distance);
	
}
