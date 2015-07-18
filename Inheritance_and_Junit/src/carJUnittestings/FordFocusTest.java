package carJUnittestings;

import static org.junit.Assert.*;

import org.junit.Test;

import car.FordFocus;
import car.HondaOdyssey;

//THIS JUnit TEST PASSES ALL TESTS

public class FordFocusTest {

	@Test
	public void testType() {
		car.FordFocus focus = new car.FordFocus("", "","","");
		assertEquals("Ford Focus is Compact Car", focus.type(), "Compact Car");
		car.HondaOdyssey honda = new car.HondaOdyssey("", "", "", "");
		assertFalse("HondaOdyssey is not a Compact Car", honda.type().equalsIgnoreCase( "Compact Car"));
		
	}

	@Test
	public void testModel() {
		car.FordFocus focus = new car.FordFocus("", "","","");
		assertEquals("make and model of FordFocus is Ford Focus", focus.model(), "Ford Focus");
		car.HondaOdyssey honda = new car.HondaOdyssey("", "", "", "");
		assertFalse("make and model of HondaOdyssey is not Ford Focus", honda.model().equalsIgnoreCase( "Ford Focus"));
	}

	
	
	@Test
	public void testFordFocus() {		
		car.FordFocus focus = new car.FordFocus("", "","","");
		assertEquals("object FordFocus created has type FordFocus", focus.getClass(), FordFocus.class);
		// since FordFocus constructor uses Car constructor, we can assume both work if FordFocus constructor works.
	}

	@Test
	public void testGetRegistrationNumber() {
		car.FordFocus focus = new car.FordFocus("", "","","AB12-CD155");
		assertEquals("Registration number of focus is AB12-CD155", focus.getRegistrationNumber(), "AB12-CD155");
		car.FordFocus focus1 = new car.FordFocus("", "","","ABELINCOLN1234");
		assertEquals("Registration number of focus1 is ABELINCOLN1234", focus1.getRegistrationNumber(), "ABELINCOLN1234");
	}

	@Test
	public void testGetType() {
		car.FordFocus focus = new car.FordFocus("", "","","");
		assertEquals("Ford Focus is Compact Car", focus.getType(), "Compact Car");
		car.HondaOdyssey honda = new car.HondaOdyssey("", "", "", "");
		assertFalse("HondaOdyssey is not a Compact Car", honda.getType().equalsIgnoreCase( "Compact Car"));
		
	}

	@Test
	public void testGetModel() {
		car.FordFocus focus = new car.FordFocus("", "","","");
		assertEquals("make and model of FordFocus is Ford Focus", focus.getModel(), "Ford Focus");
		car.HondaOdyssey honda = new car.HondaOdyssey("", "", "", "");
		assertFalse("make and model of HondaOdyssey is not Ford Focus", honda.getModel().equalsIgnoreCase( "Ford Focus"));
	}

	@Test
	public void testGetValue() {
		car.FordFocus focus = new car.FordFocus("", "","","");
		assertTrue("Price of FordFocus is $14449", focus.getValue()==14449.0);
		assertFalse("Price of FordFocus is not $22222", focus.getValue()==22222.0);
		
	}

	@Test
	public void testSetRenewalDate() {
		car.FordFocus focus = new car.FordFocus("", "","08-09-2015","");
		assertEquals("Renewal Date of focus is initialzied to 08-09-2015", focus.renewalDate, "08-09-2015");
		focus.setRenewalDate("08-09-2018");
		assertEquals("Renewal Date of focus is renewed to 08-09-2018", focus.renewalDate, "08-09-2018");
	}

	@Test
	public void testGetRenewalDate() {
		car.FordFocus focus = new car.FordFocus("", "","03-29-2016","");
		assertEquals("Renewal Date of focus is 03-29-2016", focus.getRenewalDate(), "03-29-2016");

	}
	
	
	@Test
	public void testRenewalAmount() {
		car.FordFocus focus = new car.FordFocus("", "","","");
		assertTrue("reneal fee of FordFocus is $150", focus.renewalAmount == 150);
		assertFalse("reneal fee of FordFocus is not $500", focus.renewalAmount == 500);
	}
}
