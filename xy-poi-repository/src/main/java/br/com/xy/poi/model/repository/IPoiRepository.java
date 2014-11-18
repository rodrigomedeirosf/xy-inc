package br.com.xy.poi.model.repository;

import java.util.List;

import br.com.xy.poi.model.entity.Poi;

public interface IPoiRepository {
	
	Poi save(Poi poi);
	
	List<Poi> listAll();
	
	List<Poi> searchByQuadrantPoints(Integer minX, Integer minY, Integer maxX, Integer maxY);
	
}
