package mathComputations;

public class Rollingtwos {
	public static void main(String args[]) throws Exception {

		// declarations basic objects
		int N = 100; // number of times a die is rolled
		int i, number, counter; // indices
		int[] numbers = new int[N]; // array size of N is created
		// simulate the selection of N points
		counter = 0;// initialize counter
		System.out.println("results");
		for (i = 0; i <= N - 1; i = i + 1) {
			// pick a random x and y value
			number = (int) Math.floor(6.0 * Math.random()) + 1; // returns a
																// number
																// between 1 and
																// 6
			numbers[i] = number;

			System.out.println(number + " ");
			if (number == 2)
				counter = counter + 1;// if rolled 2, add 1 to counter to keep track of how many times it's rolled in the run.

		}

		System.out.println("number of time 2 is thrown : " + counter);
		System.out.println("fraction of number of times 2 is thrown : "
				+ (double) counter / N);//divide the number of 2 is rolled by total number rolled
	}

	

}
