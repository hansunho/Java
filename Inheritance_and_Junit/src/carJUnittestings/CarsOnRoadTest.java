package carJUnittestings;

import car.CarsOnRoad;
import car.ChevroletCorvettet;
import car.FordFocus;
import car.HondaOdyssey;



public class CarsOnRoadTest {

	public static void main(String[] argv) {

		/**
		 * Create an ArrayList that take objects with type Car
		 */
		HondaOdyssey odyssey = new HondaOdyssey("Nick Cage",
				"Hollywood blvd, LA, California", "08-12-2099", "I5J5-K6L6");

		FordFocus focus = new FordFocus("Dawyne Johnson",
				"2505 Devils Glen RD, Bettendorf, Iowa", "08-12-2017",
				"A1B1-C2D2");

		ChevroletCorvettet corvettet = new ChevroletCorvettet("Ourrack Bobama",
				"Pennsylvania Ave, Washington, DC", "09-15-2099", "E3F3-G4H4");

		// create an instance of Class CarsOnRoad called cars
		CarsOnRoad cars = new CarsOnRoad();

		// if cars has type CarsOnRoad boolean value b should return true
		boolean b = cars.getClass() == CarsOnRoad.class;
		System.out.println("is B true or false?: " + b);
		System.out.println();

		// There should be no car printed since any car hasn't been added to
		// cars.
		cars.printCars();
		System.out.println();

		// add object odyssey in the arraylist in cars. if obejct is sucessfully
		// added and PrintCars() method works properly, it should print
		// "Honda Odyssey"
		cars.add(odyssey);
		cars.printCars();
		System.out.println();

		// add objects focus and corvettet. if obejcts are sucessfully added and
		// PrintCars() method works properly, it should print "Honda Odyssey",
		// "Ford Focus", and "Chevrolet Corvettet" since we are adding more
		// objects in the arraylist of cars that already has Honday Odyssey
		cars.add(focus);
		cars.add(corvettet);
		cars.printCars();
		System.out.println();

		// now we have three objects in the arrayList odyssety, focus,and
		// corvettet with registration dates of 08-12-2099, 08-12-2017, and
		// 09-15-2099 respectively. So, we have two cars that needs to be
		// renewed in the year 2099 and one car in 2017.
		// therefore, cars.totalRenewals("0000") should return 0 since there is
		// no car with registration expring in the year 0000
		cars.totalRenewals("0000");
		System.out.println();

		// cars.totalRenewals("2017") should return 1 since Focus needs to renew
		// its registration in the year 2017
		cars.totalRenewals("2017");
		System.out.println();

		// cars.totalRenewals("2017") should return 2 since odyssey and
		// corvettet need to renew its registration in the year 2099
		cars.totalRenewals("2099");
		System.out.println();

		// if we change the renewal date of odyssey to 2099, we will need to
		// renew all three cars in the year 2099
		focus.setRenewalDate("08-09-2099");
		cars.totalRenewals("2099");
		System.out.println();

		// we have three objects in the arrayList odyssey, focus,and
		// corvettet with valjues of $8,900, $14,449, and $49,432 respectively.
		// Therefore, cars.valueLargerThan(1000) will return 3 since all three
		// cars have values greater than $1,000
		cars.valueLargerThan(1000);
		System.out.println();
		// cars.valueLargerThan(9000) will only return Ford Focus and Chevrolet
		// Corvettet since Honda Odyssey's value is less than $9,000
		cars.valueLargerThan(9000);
		System.out.println();

		// cars.valueLargerThan(40000) will return only Chevrolet Corvettet
		// since only Corvettet has a value greater than $40,000;
		cars.valueLargerThan(40000);
		System.out.println();

		// cars.valueLargerThan(100000) will return no car, no car in cars is
		// worth more than $100,000.
		cars.valueLargerThan(40000);
		System.out.println();

	}
}