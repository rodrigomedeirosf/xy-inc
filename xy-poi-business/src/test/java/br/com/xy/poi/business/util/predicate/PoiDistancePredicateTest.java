package br.com.xy.poi.business.util.predicate;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.xy.poi.business.model.Poi;

public class PoiDistancePredicateTest {

	private List<Poi> poiList = new ArrayList<Poi>();

	@Before
	public void init() {

		poiList.add(new Poi(1, "Poi1", 20, 15));
		poiList.add(new Poi(2, "Poi2", 29, 16));
		poiList.add(new Poi(3, "Poi3", 15, 23));
		poiList.add(new Poi(4, "Poi4", 18, 7));

	}

	@Test
	public void predicateFilterTest() {
		List<Poi> listFilter = new ArrayList<Poi>(poiList);
		CollectionUtils.filter(listFilter, new PoiDistancePredicate(20, 10, 10));
		Assert.assertEquals(new Integer(1), listFilter.get(0).getId());
		Assert.assertEquals(new Integer(4), listFilter.get(1).getId());
	}

}
