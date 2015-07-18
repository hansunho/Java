package mathComputations;

public class pair {

	 static  int pairOfDice() {

		int count, x, y;
		x = (int) Math.floor(6.0 * Math.random()) + 1;
		y = (int) Math.floor(6.0 * Math.random()) + 1;
		count = x + y;		
		return count;
	}
	
	

public static void main(String args [])  throws Exception {

		// declarations basic objects
		int N = 1000; // number of times dice are rolled
		int i ;// index
			int[] numbers = new int[13];// array is crated to keep counts of each sum of rolled numbers.
		for (i = 2; i < 13; i = i + 1)
			numbers[i] = 0; // initialize the arrays

		for (i = 2; i <= N - 1; i = i + 1) {
			numbers[pairOfDice()]++; // each sum of numbers is stored in their respective array. for N times
		}

		
		System.out.println("\t \t number of times each sum of two numbers were rolled");
		for (i = 2; i < 13; i = i + 1)
			System.out.print(i + "\t"); // add tab after each number)
		
		
		System.out.println("");// add a line 
		for (i = 2; i < 13; i = i + 1)
			System.out.print(numbers[i] + "\t");//print respective numbers of each sum
	
	}
}
