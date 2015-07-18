package mathComputations;

public class twoinarow {

	public static void main(String args[]) throws Exception {

		// declarations basic objects
		int N = 1000; // number of times a die is rolled
		int i, number, counter; // indices
		int[] numbers = new int[N]; // array size of N is created
		// simulate the selection of N points
		counter = 0;// initialize counter
		System.out.println("results");
		for (i = 0; i <= N - 1; i = i + 1) {
			// pick a random x and y value
			number = (int) Math.floor(6.0 * Math.random()) + 1; // returns a
																// number between
																// 1 and
																// 6
			numbers[i] = number;// store number rolled on i-th try in array[i]
			if (i > 0 && numbers[i] == numbers[i - 1]) // if the number rolled
														// is same as the
														// previous roll keep
														// track of it
				counter = counter + 1;// by adding 1 to counter.
			System.out.println(number + " ");
		}

		System.out
				.println("number of time same number is thrown consecutively : "
						+ counter);
	}
}
