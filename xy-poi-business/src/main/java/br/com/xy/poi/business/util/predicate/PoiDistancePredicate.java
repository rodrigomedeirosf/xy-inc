package br.com.xy.poi.business.util.predicate;

import org.apache.commons.collections4.Predicate;

import br.com.xy.poi.business.model.Poi;


public class PoiDistancePredicate implements Predicate<Poi> {
	
	private Integer coordinateX;
	private Integer coordinateY;
	private Integer distance;
	
	public PoiDistancePredicate(Integer coordinateX, Integer coordinateY, Integer distance) {
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		this.distance = distance;
	}
	
	@Override
	public boolean evaluate(Poi poi) {
		
		Integer diffX = Math.max(coordinateX, poi.getX()) - Math.min(coordinateX, poi.getX());
		Integer diffY = Math.max(coordinateY, poi.getY()) - Math.min(coordinateY, poi.getY());
		return Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2)) <= distance;
	}

}
