package HeapSort;

public class Heap<T extends Comparable<T>> {

	protected T[] array;
	protected int size;

	public Heap() {
		array = (T[]) new Comparable[20];
		size = 0;
	}
	

}