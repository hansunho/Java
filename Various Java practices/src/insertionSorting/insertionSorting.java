package insertionSorting;

public class insertionSorting {
	
	// method to sort using the insertion sort
	public static void insertionSort (int [] a) {
		   for (int k = 1; k < a.length; k++) {
			   
		      int item = a[k];
		      
		      int i = k-1;
		      
		      while ((i >= 0) && a[i] < item){
		    	  
		         a[i+1] = a[i];
		         
		         i--;
		         
		      }
		      
		      a[i+1] = item;
		      
		   }
		   
		} 
	
	
	public void addMultiSet(int [] a , int item)
	{		
	    int i = a.length-1;		
	    
		   while ((i >= 0) && a[i] < item){
		    	  
		         a[i+1] = a[i];
		         
		         i--;
		         
		      }
		      
		      a[i+1] = item;
		
		
	}
	public void addMultiSet2(int [] a , int item)
	{		
	    int i = a.length-1;		
	    
		   while ((i >= 0) && a[i] < item){
		    	  
		         a[i+1] = a[i];
		         
		         i--;
		         
		      }
		      
		      a[i+1] = item;
		//item.setCount(number);
		
	}
}
