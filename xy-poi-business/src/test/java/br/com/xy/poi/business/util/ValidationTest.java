package br.com.xy.poi.business.util;

import org.junit.Assert;
import org.junit.Test;

import br.com.xy.poi.business.util.Validation;

public class ValidationTest {
	
	@Test
	public void validNotBlankValues(){
		try{
			Validation.notBlank("a", "zup", "poi", "poi zup");
			Assert.assertTrue(true);
		}catch(IllegalArgumentException e){
			Assert.assertTrue(e.getMessage(), false);
		}
	}
	
	@Test
	public void invalidNotBlankValueWithEmptyString(){
		try{
			Validation.notBlank("");
			Assert.assertTrue(false);
		}catch(IllegalArgumentException e){
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void invalidNotBlankValueWithNullValue(){
		try{
			Validation.notBlank(null, null);
			Assert.assertTrue(false);
		}catch(IllegalArgumentException e){
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void invalidNotBlankValueWithBlankValue(){
		try{
			Validation.notBlank(" ");
			Assert.assertTrue(false);
		}catch(IllegalArgumentException e){
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void validPositiveNumber(){
		try{
			Validation.positiveNumber(0, 1, 50, 100000000);
			Assert.assertTrue(true);
		}catch(IllegalArgumentException e){
			Assert.assertTrue(e.getMessage(), false);
		}
	}
	
	@Test
	public void invalidPositiveNumber(){
		try{
			Validation.positiveNumber(-1);
			Assert.assertTrue(false);
		}catch(IllegalArgumentException e){
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void validPositiveValue(){
		try{
			Validation.positiveNumber("0", "1", "50", "100000000");
			Assert.assertTrue(true);
		}catch(IllegalArgumentException e){
			Assert.assertTrue(e.getMessage(), false);
		}
	}
	
	@Test
	public void invalidPositiveValue(){
		try{
			Validation.positiveNumber("-1");
			Assert.assertTrue(false);
		}catch(IllegalArgumentException e){
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void validNumber(){
		try{
			Validation.isNumber("-1", "10", "0", "1004230", "60", "-93287429", "00003432787", "-09337237");
			Assert.assertTrue(true);
		}catch(IllegalArgumentException e){
			Assert.assertTrue(e.getMessage(), false);
		}
	}
	
	@Test
	public void invalidNumber(){
		try{
			Validation.isNumber("a");
			Assert.assertTrue(false);
		}catch(IllegalArgumentException e){
			Assert.assertTrue(true);
		}
	}
	
}
