package carJUnittestings;

import static org.junit.Assert.*;

import org.junit.Test;

import car.Owner;

//THIS JUnit TEST PASSES ALL TESTS

public class OwnerTest {

	@Test
	public void testOwner() {
		car.Owner owner = new car.Owner("", "");
		assertEquals("object onwer created has type Owner", owner.getClass(), car.Owner.class);		
	}

	@Test
	public void testGetName() {
		car.Owner owner = new car.Owner("John", "");
		assertEquals("name of owner is John", owner.getName(), "John");
	}

	@Test
	public void testSetName() {
		car.Owner owner = new car.Owner("John", "");
		owner.setName("Blake");
		assertEquals("Name of owner is set to Blake", owner.getName(), "Blake");
	}

	@Test
	public void testGetAddress() {
		car.Owner owner = new car.Owner("", "2505 Devils Glend, Bettendorf, Iowa");
		assertEquals("address of owner is 2505 Devils Glend, Bettendorf, Iowa", owner.getAddress(), "2505 Devils Glend, Bettendorf, Iowa");
	}

	@Test
	public void testSetAddress() {
		car.Owner owner = new car.Owner("", "8th Ave. Grinnell, Iowa");
		assertEquals("address of owner is set to 8th Ave. Grinnell, Iowa",owner.getAddress(),"8th Ave. Grinnell, Iowa");
	}

}
