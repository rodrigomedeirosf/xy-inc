package br.com.xy.poi.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.xy.poi.business.model.Poi;
import br.com.xy.poi.business.service.IPoiService;
import br.com.xy.poi.business.util.Validation;
import br.com.xy.poi.web.util.json.JsonResult;
import br.com.xy.poi.web.util.message.MessageHandler;

@RestController
@RequestMapping("/poi")
public class PoiController {
	
	@Autowired
	IPoiService poiService;
	
	private static Logger log = LoggerFactory.getLogger(PoiController.class);
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public JsonResult listPoi(){
		try{
			return JsonResult.success(poiService.listAll());
		}catch(Exception e){
			log.error("Error listing poi", e);
			return JsonResult.error(e.getMessage());
		}
	}
	
	@RequestMapping(value="/search/x-axis/{x:[0-9]+}/y-axis/{y:[0-9]+}/distance/{distance:[0-9]+}", method=RequestMethod.GET)
	public JsonResult searchNearbyPoints(@PathVariable("x") Integer coordinateX, @PathVariable("y") Integer coordinateY, @PathVariable Integer distance){
		try{
			Validation.positiveNumber(coordinateX, coordinateY, distance);
			return JsonResult.success(poiService.findByDistance(coordinateX, coordinateY, distance));
		}catch(Exception e){
			log.error("Error search poi by distance", e);
			return JsonResult.error(e.getMessage());
		}
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public JsonResult createPoi(@RequestParam("name") String name, @RequestParam("coordinateX") String coordinateX, @RequestParam("coordinateY") String coordinateY){
		try{
			Validation.notBlank(name);
			Validation.positiveNumber(coordinateX, coordinateY);
			poiService.save(new Poi(name, Integer.valueOf(coordinateX), Integer.valueOf(coordinateY)));
			return JsonResult.success(MessageHandler.getMessage(name, MessageHandler.POI_SAVE_SUCCESS));
		}catch(IllegalArgumentException e){
			return JsonResult.error(MessageHandler.getMessage(MessageHandler.POI_SAVE_ILLEGAL_ARGUMENT));
		}catch(Exception e){
			return JsonResult.error(e.getMessage());
		}
	}
	
}
