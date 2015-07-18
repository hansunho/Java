package queues;

public class QueueNode <E>
{
   /**
    * Each QueueNode has a data field of type E
    * and a next field to support a singly-linked list
    */
   private E data;
   private QueueNode <E> next;

   /**
    * The default construtor sets the data and next fields to null
    */
   public QueueNode ()
   {
      data = null;
      next = null;
   }

   /**
    * An alternative constructor has both data and next parameters
    */
   public QueueNode (E origData, QueueNode<E> origNext)
   {
      data = origData;
      next = origNext;
   }

public E getData() {
	return data;
}

public void setData(E data) {
	this.data = data;
}

public QueueNode<E> getNext() {
	return next;
}

public void setNext(QueueNode<E> next) {
	this.next = next;
}

   // other methods include the usual getters and setters

}
