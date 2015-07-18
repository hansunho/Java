package BookstoreItemManagement;

public class QueueNode<E> {
	/**
	 * Each QueueNode has a data field of type E and a next field to support a
	 * singly-linked list
	 */
	// name of the item
	private String itemName;
	// number of each item
	private int count;
	// next Node
	private QueueNode<E> next;

	/**
	 * The default constructor sets the itemname, count, and next fields to null
	 */
	public QueueNode() {
		itemName = null;
		count = -1;
		next = null;
	}

	/*
	 * Cosntructor for QueueNode for nodes with given name. set itemName to
	 * name. and count to 1
	 */
	public QueueNode(String name) {
		itemName = name;
		count = 1;
		next = null;
	}

	// getters and setters for the fields
	public String getItemName() {
		return itemName;
	}

	public void setData(String data) {
		this.itemName = data;
	}

	public QueueNode<E> getNext() {
		return next;
	}

	public void setNext(QueueNode<E> next) {
		this.next = next;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int num) {
		count = num;
	}

	public String toString() {
		return "Item Name: " + this.itemName +"\n"
				+ "Number of the item in the inventory:" + this.count;}

}
