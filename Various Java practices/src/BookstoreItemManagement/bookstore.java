package BookstoreItemManagement;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class bookstore<bookstoreItem> {

	public QueueNode<bookstoreItem> tail;
	public QueueNode<bookstoreItem> first;

	public bookstore() {
		tail = null;
		first = null;
	}

	// For the sake of readability and considering the size of an inventory will
	// not be very large for this problem, I will implement a helper function
	// that decides
	// whether a given name of item exists in the inventory
	// If it exists, it will increment the amount of that item and return
	// true.if item is not found return false without change amount.
	public boolean searchItem(String name) {
		QueueNode<bookstoreItem> ptr = tail;

		do {
			// if item is found increment the amount of the item by 1 and return
			// true;

			if (ptr.getItemName().compareTo(name) == 0) {
				ptr.setCount(ptr.getCount() + 1);
				return true;
			}
			// continue searching
			else
				ptr = ptr.getNext();
		}
		// loop until either looked at the whole list or
		while (ptr.getItemName().compareTo(tail.getItemName()) != 0);
		// if item not found, return false
		return false;
	}

	// look for an item that has the same name as the parameter. return the
	// number of items for that inventory item, or -1 if the item is not foun in
	// inventory. if the item is found, the pointer 'first' should point to that
	// item.
	public int lookup(String name) {
		QueueNode<bookstoreItem> temp = first;
		// check if the current item first is pointing is the matching item
		do {
			// if so return the number of item
			if (first.getItemName().compareTo(name) == 0)
				return first.getCount();
			// if not keep moving the fisrt pointer
			else
				first = first.getNext();
			// loop until the whole list has been searched
		} while (first.getItemName().compareTo(temp.getItemName()) != 0);

		// if item is not found return -1
		return -1;

	}

	public void add(String itemName) {

		QueueNode<bookstoreItem> node = new QueueNode<bookstoreItem>(itemName);
		QueueNode<bookstoreItem> ptr = tail;

		// if there is no item in the inventory make that node both the tail
		// and first item
		if (tail == null) {
			tail = node;
			tail.setNext(tail);
			// initialize the pointer 'first'
			first = tail;
		}
		// if there is the same kind of item in the inventory, just increment
		// the amount of the item
		else if (searchItem(itemName))
			;

		// if there is only one item add the new item so that item becomes
		// the new tail pointing to the first item in the list.
		else if (tail.getItemName().compareTo(tail.getNext().getItemName()) == 0) {
			QueueNode<bookstoreItem> temp = tail;

			tail = node;
			tail.setNext(temp);
			tail.getNext().setNext(tail);
			// update the pointer 'first'
			first = tail.getNext();
		}

		// other wise keeping the tail and first item consistent, add the
		// new
		// item right after the first item
		else {

			// set the new bookstoreItem to point to the bookstoreItem after
			// the
			// first node.
			node.setNext(first.getNext());

			// set the first bookstoreItem's next to point to the new item.
			first.setNext(node);
		}

	}

	// Print the entire inventory
	public void print() {
		// create a temporary pointer too loop through the array. initially set
		// newptr to the first item
		QueueNode<bookstoreItem> newptr = tail.getNext();

		// prints and loop until it makes the round back to the first item

		do {
			System.out.println(newptr);
			newptr = newptr.getNext();
		}

		while (newptr.getItemName().compareTo(tail.getNext().getItemName()) != 0);

	}

	// count the number of elements in the circular list
	public int numOfElements(QueueNode<bookstoreItem> tailNode) {
		// if there is more than 1 item

		if (tailNode != null) {
			int count = 0;
			QueueNode<bookstoreItem> i = tailNode.getNext();
			// increase counter and renew i until loop breaks(right before the
			// complete loop)
			while (tailNode.getItemName().compareTo(i.getItemName()) != 0) {

				count++;

				i = i.getNext();

			}

			// add 1 to count to make up for the tail element
			return (count + 1);
		} else
			return 0;
	}

	public Iterator<QueueNode<bookstoreItem>> iterator() {
		return new LocalIterator();
	}

	private class LocalIterator implements Iterator<QueueNode<bookstoreItem>> {
		// node of last bookstoreItem returned by iterator

		private QueueNode<bookstoreItem> lastReturned;

		// keeps track of the node before lastReturned
		private QueueNode<bookstoreItem> lastLastReturned;
		// shows whether remove can be called or not.
		private boolean removeAvailable;
		// total number of iteration to be completed for the iterator
		private int numberOfLoops;

		// last Delete item from remove()
		private String lastDeleteItem;

		// index
		public int i = 0;

		// Create an iterator
		public LocalIterator() {
			lastReturned = tail;
			lastLastReturned = null;
			// remove function initially not available
			removeAvailable = false;
			numberOfLoops = numOfElements(tail);
			lastDeleteItem = "";
		}

		@Override
		public boolean hasNext() {

			if (i < numberOfLoops)
				return true;
			else
				return false;

		}


		@Override
		public QueueNode<bookstoreItem> next() {
			lastLastReturned = lastReturned;
			lastReturned = lastReturned.getNext();

			i++;
			// enable remove after a call to next.
			removeAvailable = true;
			return lastReturned;

		}

		@Override
		public void remove() {

			// if there is only one item left to be removed in the inventory
			if (removeAvailable
					&& lastReturned.getItemName().compareTo(
							lastReturned.getNext().getItemName()) == 0) {
				// if there is more than one of that item, simply decrement the
				// amount by 1
				if (lastReturned.getCount() >= 2)
					lastReturned.setCount(lastReturned.getCount() - 1);
				// if there is no more item left in the inventory after this
				// item, empty the inventory
				else if (lastReturned.getCount() == 1) {
		
					lastReturned = null;
				
				}

			}
			// other wise
			// if there is more than one of that item, simply decrement the
			// amount by 1
			else if (removeAvailable && lastReturned.getCount() >= 2) {

				lastReturned.setCount(lastReturned.getCount() - 1);
			}
			// if there is only one item to be removed, delete the node from the
			// linked-circular list
			else if (removeAvailable && lastReturned.getCount() == 1) {
				lastDeleteItem = lastReturned.getItemName();
				lastLastReturned.setNext(lastReturned.getNext());
				lastReturned = lastLastReturned;
			}

			// remove is unavaialbe until next is called
			removeAvailable = false;

		}

	}

	public static void main(String args[]) {

		bookstore inventory = new bookstore();

		Iterator it = inventory.iterator();
		System.out.println("does iterator have next? "+it.hasNext());
		
		inventory.add("1");
		inventory.add("2");
		inventory.add("3");
		inventory.add("4");
		inventory.add("5");
		inventory.add("6");
		inventory.add("1");
		inventory.add("2");
		inventory.add("3");
		inventory.add("4");
		inventory.add("5");
		inventory.add("6");		
		
		
//		
//		 while (it.hasNext()) {
//		  it.next();
//		  it.remove();
//			}
//		inventory.print();
		
//		 }
//		System.out.println("##");


	}
}