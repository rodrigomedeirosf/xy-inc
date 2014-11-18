package br.com.xy.poi.model.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.xy.poi.model.entity.Poi;
import br.com.xy.poi.model.repository.IPoiRepository;

@Repository
public class PoiRepository extends CoreRepository implements IPoiRepository {

	@Override
	public Poi save(Poi poi) {
		getSession().save(poi);
		return poi;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Poi> listAll() {
		return getSession().createCriteria(Poi.class).list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Poi> searchByQuadrantPoints(Integer minX, Integer minY, Integer maxX, Integer maxY) {
		Criteria poiCriteria = getSession().createCriteria(Poi.class);
		poiCriteria.add(Restrictions.and(
				Restrictions.and(Restrictions.ge("x", minX),Restrictions.ge("y", minY)),
				Restrictions.and(Restrictions.le("x", maxX),Restrictions.le("y", maxY))
				));
		return poiCriteria.list();
		
	}

}
