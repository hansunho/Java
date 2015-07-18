import java.util.ArrayDeque;

public class Queue207Implementation<E> implements Queue207<E> {

	private ArrayDeque<E> q;

	public Queue207Implementation() {
		q = new ArrayDeque<E>();
	}

	@Override
	public boolean add(E e) {
		return q.add(e);
	}

	@Override
	public E remove() {
		return q.remove();
	}

	@Override
	public E element() {
		return q.element();
	}

	@Override
	public int size() {
		return q.size();
	}
	
	


public static void main(String[] argv) {
	Queue207Implementation<String> array = new Queue207Implementation<String>();
	
	array.add("D");
	System.out.println(array.element());
}

}