/*Sun Han & Caleb Kumar
 *
 * 
 * 11/23/14
 * 
 * SINGLY LINKED LIST EXTRA CREDIT LAB
 */

package queues;

import java.util.NoSuchElementException;

//E represents the generic type
public class Queues<E> extends QueueNode<E> implements Queue207<E> {

	// head to points to the first element of the linked list while the tail
	// points to the end of the linked list
	public QueueNode<E> head;
	public QueueNode<E> tail;
	
	// counters to keep track of how many times dequeue has been called.
	// initialize to 0.
	public int numDequeue = 0;

	// getters and setter for numDequeue;
	public int getNumDequeue() {
		return numDequeue;
	}
	public void setNumDequeue(int numDequeue) {
		this.numDequeue = numDequeue;
	}

	
	// Since no elements are in our queue to begin, both head and tail are null
	public Queues() {
		head = null;
		tail = null;
	}

	@Override
	public boolean enqueue(E e) {

		// We can't add a null to the linked list
		if (e == null) {
			throw new NullPointerException();
		}

		// create new node with given data
		QueueNode<E> node = new QueueNode<E>(e, null);

		// If this is the first element added to the linked list, set and head
		// and tail to created node since we will only have one element
		if (head == null) {
			head = node;
			tail = node;

		}
		// otherwise add to tail of the queue
		else {
			tail.setNext(node);
			tail = node;

		}
		return true;
	}

	// Remove from head of queue and return its data
	@Override
	public E dequeue() throws NoSuchElementException {
		// TODO Auto-generated method stub
		E temp;

		// increment numDequeue every time dequeue is called.
		numDequeue++;

		// can't remove element if queue is empty
		if (head == null) {
			throw new NoSuchElementException();
		}

		// If we only have one element, set both head and tail to null
		else if (head == tail) {
			temp = head.getData();
			head = null;
			tail = null;
			return temp;
		}

		else {
			temp = head.getData();
			head = head.getNext();
			return temp;
		}
	}

	// Retrieve the data of head of queue
	@Override
	public E element() throws NoSuchElementException {
		{
			// If queue is empty, throw exception
			if (head == null) {
				throw new NoSuchElementException();
			}

			else {
				return head.getData();
			}

		}
	}

	// Obtain size of queue by going through entire linked list and adding to
	// counter everytime
	@Override
	public int size() {
		// TODO Auto-generated method stub
		int counter = 0;
		QueueNode<E> newptr = new QueueNode<E>();
		newptr = head;

		while (newptr != null) {
			counter++;
			newptr = newptr.getNext();
		}

		return counter;
	}

	// Print the entire queue
	public void print() {
		// TODO Auto-generated method stub
		QueueNode<E> newptr = new QueueNode<E>();
		newptr = head;

		while (newptr != null) {
			System.out.println(newptr.getData());
			newptr = newptr.getNext();
		}

	}

	public static void main(String args[]) {

		Queues<String> list = new Queues<String>();

		list.enqueue("a");
		list.enqueue("b");
		list.enqueue("c");

		System.out.println(list.element());

		System.out.println(list.size());

		list.dequeue();
		list.dequeue();

		list.print();

	}

}
