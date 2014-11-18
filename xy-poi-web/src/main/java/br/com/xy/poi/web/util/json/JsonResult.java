package br.com.xy.poi.web.util.json;

public class JsonResult {
	
	private Boolean result;
	private Object data;
	
	private JsonResult(Boolean result, Object data){
		this.result = result;
		this.data = data;
	}
	
	public static JsonResult success(Object data){
		return new JsonResult(true, data);
	}
	
	public static JsonResult error(Object data){
		return new JsonResult(false, data);
	}
	
	public Boolean isResult() {
		return result;
	}
	
	public Object getData() {
		return data;
	}
	
}
