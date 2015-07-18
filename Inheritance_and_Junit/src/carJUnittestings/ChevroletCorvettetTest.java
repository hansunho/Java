package carJUnittestings;

import static org.junit.Assert.*;

import org.junit.Test;

import car.ChevroletCorvettet;

//THIS JUnit TEST PASSES ALL TESTS


public class ChevroletCorvettetTest {

	@Test
	public void testChevroletCorvettet() {
		car.ChevroletCorvettet corvettet = new car.ChevroletCorvettet("", "","","");
		assertEquals("object corvettet created has type ChevroletCorvettet", corvettet.getClass(), ChevroletCorvettet.class);
	}

	@Test
	public void testGetType() {	
		
		car.ChevroletCorvettet corvettet = new car.ChevroletCorvettet("", "","","");
	assertEquals("corvettet is a Sports Car", corvettet.getType(), "Sports Car");
	
	car.FordFocus focus = new car.FordFocus("", "","","");
	assertFalse("Ford Focus is not a Sports Car", focus.getType().equalsIgnoreCase("Sports Car"));
	}

	@Test
	public void testGetModel() {
		car.ChevroletCorvettet corvettet = new car.ChevroletCorvettet("", "","","");
		assertEquals("make and model of ChevroletCorvettet is Chevrolet Corvettet ", corvettet.getModel(), "Chevrolet Corvettet");
		assertFalse("make and model of ChevroletCorvettet is not Ford Focus", corvettet.getType().equalsIgnoreCase("Ford Focus"));
	}

	@Test
	public void testGetValue() {
		car.ChevroletCorvettet corvettet = new car.ChevroletCorvettet("", "","","");
		assertTrue("ChevroletCorvettet has the price of $49,432", corvettet.getValue() == 49432);
		assertFalse("ChevroletCorvettet does not have the price of $23", corvettet.getValue() == 23);
	}

	@Test
	public void testRenewalAmount() {
		car.ChevroletCorvettet corvettet = new car.ChevroletCorvettet("", "","","");
		assertTrue("reneal fee of ChevroletCorvettet is $500", corvettet.renewalAmount == 500);
		assertFalse("reneal fee of ChevroletCorvettet is not $150", corvettet.renewalAmount == 150);	}
}
