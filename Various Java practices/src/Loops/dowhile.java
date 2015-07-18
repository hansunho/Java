	package Loops;
	
	public class dowhile {
		
		public static void main(String[] args) {
				int i, n, factorial;
				
				n=10;
				
				i = 1;
				factorial = 1;
				do {
					factorial = i * factorial;
					i = i + 1;
					System.out.println(factorial);
				} while (i <= n);
			
			}
}
