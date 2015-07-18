package Loops;

public class whileloop {
	public static void main(String[] args) {
		int factorial;
		int i, n;
		n = 6;
		i = 1;
		factorial = 1;
		while (i <= n) {
			factorial = i * factorial;
			i = i + 1;
			System.out.println(factorial);
		}
	}
}