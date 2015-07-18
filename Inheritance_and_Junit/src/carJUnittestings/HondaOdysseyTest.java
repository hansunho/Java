package carJUnittestings;

import static org.junit.Assert.*;

import org.junit.Test;

import car.FordFocus;
import car.HondaOdyssey;

//THIS JUnit TEST PASSES ALL TESTS

public class HondaOdysseyTest {

	@Test
	public void testHondaOdyssey() {
		car.HondaOdyssey odyssey = new car.HondaOdyssey("", "","","");
		assertEquals("object odyssey created has type HondaOdyssey", odyssey.getClass(), HondaOdyssey.class);
	}

	@Test
	public void testGetRegistrationNumber() {
		car.HondaOdyssey odyssey = new car.HondaOdyssey("", "","","AB12-CD155");
		assertEquals("Registration number of odyssey is AB12-CD155", odyssey.getRegistrationNumber(), "AB12-CD155");		
	}

	@Test
	public void testGetType() {
		car.HondaOdyssey odyssey = new car.HondaOdyssey("", "","","");
		assertEquals("HondaOdyssey is a Minivan", odyssey.getType(), "Minivan");
		
		car.FordFocus focus = new car.FordFocus("", "","","");
		assertFalse("Ford Focus is not a Minivan", focus.getType().equalsIgnoreCase("Minivan"));
	}
	
	
	@Test
	public void testGetModel() {
		car.HondaOdyssey odyssey = new car.HondaOdyssey("", "","","");
		assertEquals("HondaOdysseyhas make and model name of Honda Odyssey", odyssey.getModel(), "Honda Odyssey");
		
	}

	@Test
	public void testGetValue() {
		car.HondaOdyssey odyssey = new car.HondaOdyssey("", "","","");
		assertTrue("HondaOdyssey has the price of $8,900", odyssey.getValue() == 8900);
	}
	@Test
	public void testRenewalAmount() {
		car.HondaOdyssey odyssey = new car.HondaOdyssey("", "","","");
		assertTrue("reneal fee of HondaOdyssey is $100", odyssey.renewalAmount == 100);
		assertFalse("reneal fee of HondaOdyssey is not $150", odyssey.renewalAmount == 150);	}
}
