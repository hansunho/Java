package Loops;

public class forloops {

	public static void main(String[] args) {
		int factorial;
		int i, n;
		n = 5;
		
		for (i = 1, factorial = 1; i <= n; factorial = factorial * i, i = i + 1)
			System.out.println(factorial);
		
		for (i=1; i<11; i++)
			System.out.println(i);
	}
}

