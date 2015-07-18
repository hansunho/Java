import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class Queue207Han {

	Queue207Implementation<String> que = new Queue207Implementation<String>();

	// que is empty so element() should return NoSuchElementException
	@Test(expected = NoSuchElementException.class)
	public void testElement() {
		que.element();
	}

	// que is empty so remove() should return NoSuchElementException
	@Test(expected = NoSuchElementException.class)
	public void testRemove() {
		que.remove();
	}

	@Test
	public void testSize() {
		assertEquals("que is empty", 0, que.size());
	}

	// adding null should throw an NullPointerException
	@Test(expected = NullPointerException.class)
	public void testAdd() {
		que.add(null);
	}

	@Test
	public void testAddSizeRemoveElement() {
		// add three items in the queue:"one", "two", and "three" in that order.
		// if successfully added they all should returns true
		assertEquals("add 'one' to que", true, que.add("one"));
		assertEquals("add 'two' to que", true, que.add("two"));
		assertEquals("add 'three' to que", true, que.add("three"));

		// three items are added in the queue, so it should return three when
		// size is called
		assertEquals("que has three items", 3, que.size());

		// The head of the queue is "one" since its the first element added.
		// element should return "one" and the head stays unchanged
		assertEquals("the head of que is 'one'", "one", que.element());
		// The head of the queue is "one" since its the first element added.
		// element should return "one" and the head changes to the second item
		assertEquals("the head of que is 'one'", "one", que.remove());
		// since "one" is removed, only two items in the queue
		assertEquals("now que has two elements", 2, que.size());
		// The head of the queue is "two", element should return "two" and the
		// head stays unchanged
		assertEquals("the head of que is now 'two'", "two", que.element());
		// The head of the queue is "two", element should return "two" and the
		// head is deleted and changed to the next item
		assertEquals("the head of que is now 'two'", "two", que.remove());
		// The head of the queue is "three", element should return "three" and
		// the
		// head is deleted. now there is no item in the queue
		assertEquals("the head of que is now 'three'", "three", que.remove());
		// queue is empty,size returns 0
		assertEquals("now que has now element", 0, que.size());
	}

}