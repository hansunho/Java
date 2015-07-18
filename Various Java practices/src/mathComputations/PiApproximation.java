package mathComputations;

//import java.lang.Math; // needed for Random method
public class PiApproximation {
	// class provides a framework for checking whether the parentheses
    // in a line of input match

    public static void main (String args [])
        throws Exception 
        {

        // Declarations
        int N = 5;  // Number of points to be selected
        int count = 0; // Count of points in circle
        int i;         // loop index
        double x, y; // coordinates for a randomly-generated point

		// simulate the selection of N points
		for (i = 0; i < N; i = i + 1) {
			// pick a random x and y value
			x = Math.random(); // returns a number >=0 and < 1.0
			y = Math.random();
			// check if point is in circle of radius 1.0
			if (x * x + y * y <= 1.0)
				count = count + 1;
			System.out.println("x is " + x);
			System.out.println("y is " + y);
			double point = x * x + y * y;
			System.out.println("x^2 + y^2 is " + point);
			System.out.println("count is " + count);
		}
        
        System.out.println ("In selecting " + N + " points in the unit square");
        System.out.println ("in the first quadrant, " + count + " points ");
        System.out.println ("were also in the unit circle.");
        System.out.println ("This gives " + 4.0*count/N 
                            + " as an approximation to Pi.");
        
      
    }
}