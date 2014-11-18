package br.com.xy.poi.business.util;

import org.apache.commons.lang3.StringUtils;

public final class Validation {
	
	private Validation(){}
	
	public static void notBlank(String... values){
		for(String value: values){
			if(StringUtils.isBlank(value)){
				throw new IllegalArgumentException();
			}
		}
	}
	
	public static void positiveNumber(Number... values){
		for(Number value: values){
			if(value == null || value.intValue() < 0){
				throw new IllegalArgumentException();
			}
		}
	}
	
	public static void positiveNumber(String... values){
		Validation.isNumber(values);
		for(String value: values){
			Integer number = Integer.valueOf(value);
			if(number < 0){
				throw new IllegalArgumentException();
			}
		}
	}
	
	public static void isNumber(String... values){
		for(String value: values){
			try{
				Integer.valueOf(value);
			}catch(NumberFormatException e){
				throw new IllegalArgumentException();
			}
		}
	}
	
}
