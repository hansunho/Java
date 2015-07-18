package mathComputations;

public class PrimeSieve {

	// This program implements the Sieve of Eratosthenes

	public static void main(String args[]) throws Exception {

		// declarations basic objects
		int M = 300; // size of sieve
		int i, number; // indices

		// Determine size of sieve
		System.out
				.println("Use of the Sieve of Eratosthenes to compute primes");
		System.out.println("Positive integers up to " + M
				+ " will be considered ");

		// set up sieve
		boolean[] crossedOut = new boolean[M + 1];
		// use size M+1 for elemens 0 through M
		for (i = 0; i <= M; i++)
			// i++ is an abbreviation for i = i + 1
			crossedOut[i] = false;

		// follow cross-out process
		for (number = 2; number < M; number++) {
			if (!crossedOut[number]) { // cross out multiples of number
				i = 2 * number;
				while (i <= M) {
					crossedOut[i] = true;
					i = i + number;
				}
			}
		}

		// print list of primes
		System.out.println("The following prime numbers have been found");
		int numberOnLine = 0;

		for (i = 2; i <= M; i++) {
			if (!crossedOut[i]) {
				System.out.print(i + "\t"); // add tab after each number
				numberOnLine++;
				if (numberOnLine == 8) {
					System.out.println(); // start a new line every 8 numbers
					numberOnLine = 0;
				}
			}
		}
		System.out.println();
	}
}
