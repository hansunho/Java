package iteratorExamples;

import java.lang.Iterable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * a correct implementation of an Iterator for an array, 
 * based upon
 * http://www.java-forums.org/new-java/2747-implementing-iterator.html
 */
public class MyArray1<AnotherClass> implements Iterable<AnotherClass>, Iterator<AnotherClass> 
{
	private int count;
	private AnotherClass[] collection; // collection.size() change to collection.length throughout
	 
	public MyArray1(){
		// details added by HMW
		collection = (AnotherClass []) new Object[10];
	}
	 
	 
	//constructors and other stuff here
	// details added by HMW
	AnotherClass get (int i) {
		if (i < 0 || i >= collection.length)
			throw (new NoSuchElementException());
		return collection[i];
	}
	
	void put (int i, AnotherClass ac){
		if (i < 0 || i >= collection.length)
			throw (new NoSuchElementException());
		collection[i] = ac;
	}
	 
	// Iterator material starts here
	public Iterator<AnotherClass> iterator() {
	    return this;
	}
	 
	public boolean hasNext() {
	    return count < collection.length;
	}
	 
	public AnotherClass next() {
	    if(count == collection.length){
	            throw new NoSuchElementException();
	    }
	    return collection[count++]; // ++ fix added according to Forum
	}	
	 
	public void remove() {
	    throw new UnsupportedOperationException();
	}
	
	// method added per Forum's discussion
	public void reset() {
		count = 0;
	}
	
	public static void main (String args[]) {
		MyArray1<Integer> mc = new MyArray1<Integer>();
		
		int i;
		
		for (i = 0; i < 10; i++)
			mc.put(i, 2*i);
		
		System.out.println();

		// print out using Iterator
                System.out.println ("First output segment:");
		for (Integer item : mc) 
                    {
                        System.out.print("\t" + item);
                    }
		System.out.println();
		
		mc.reset();

		// print out using Iterator
                System.out.println ("Second output segment:");
		for (Integer item1 : mc) 
                    {  
                        System.out.print("\tout  " + item1);	
                        for (Integer item2 : mc) 
                            {   
                                System.out.print("\tin   " + item2);	
                            }			
                        System.out.println();
                    }			
		System.out.println();

		mc.reset();

		// print a third time using Iterator
                System.out.println ("Third output segment:");
		Iterator <Integer> it = mc.iterator();
		while (it.hasNext())
			System.out.print("\t" + it.next());
                System.out.println();
	}

}
