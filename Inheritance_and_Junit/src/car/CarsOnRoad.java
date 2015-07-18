package car;
import java.util.ArrayList;
public class CarsOnRoad {
	
	/**
	 * null constructor for class CarsOnRad
	 */
	public CarsOnRoad() {
	};

	/**
	 * carList array list that can contain objects type Car
	 */
	 ArrayList<Car> carList = new ArrayList<Car>();
	
	
	/**
	 * adds an Car typed object into ArrayList<Car> carList
	 * 
	 * @param car an object with type Car to be added in the array list carList
	 */
	public void add(Car car)
	{	
		
		carList.add(car);
	
	}

	
	/**
	 * prints all cars in ArrayList<Car> carList.
	 * 
	 */
	public  void printCars() {
		System.out.println("List of cars in the collection");
		for (int i = 0; i < carList.size(); i++) {

			System.out.println(carList.get(i).getModel());

		}
		System.out.println("End of List");
	}

	/**
	 * goes through the cars in ArrayList<Car> carList and find those whose
	 * registration expire in the given year (String year) and prints those cars
	 * that have registartion expiring in yaer. Also prints the total number of
	 * cars that need renewal in that given year.
	 * 
	 * @param year
	 *            Year to check for registration date for each car given in 
	 */
	public void totalRenewals(String year) {
		int numberOfCarsToBeRenewed = 0;
		System.out.println("List of cars to be renewed this year");
		
		for (int i = 0; i < carList.size(); i++) {
			if (carList.get(i).getRenewalDate().contains(year)) {
				System.out.println(carList.get(i).getModel());
				numberOfCarsToBeRenewed++;
			}
		}
		System.out.println("End of List");
		System.out.println("Total Number of Cars to be Renewed in the year "
				+ year + " = " + numberOfCarsToBeRenewed);
	}

	/**
	 * compares the current values of cars in ArrayList<Car> carList to val. If
	 * current value of a car is greater than the given value val, prints that
	 * car. If not, do not print that car.
	 * 
	 * @param val
	 *            value to be compared to values of cars in ArrayList<Car>
	 *            carList
	 */
	public  void valueLargerThan(double val) {
		System.out.println("Cars value greater than $" + val);
		for (int i = 0; i < carList.size(); i++) {
			if (carList.get(i).getValue() > val)
				System.out.println(carList.get(i).getModel());
		}
		System.out.println("End of List");
	}


	
}
