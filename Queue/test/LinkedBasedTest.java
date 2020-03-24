package eg.edu.alexu.csd.datastructure.queue.cs1_cs53;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedBasedTest {

	@Test
	void test() {
		LinkedBased q = new LinkedBased();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);

		assertEquals(1, q.dequeue());
		assertEquals(2, q.dequeue());
		assertEquals(4, q.size());

		assertEquals(false, q.isEmpty());
		assertEquals(3, q.dequeue());
		assertEquals(3, q.size());
		q.enqueue(67);
		q.enqueue(-3);
		assertEquals(5, q.size());
		assertEquals(4, q.dequeue());
		assertEquals(5, q.dequeue());
		assertEquals(3, q.size());
		assertEquals(6, q.dequeue());
		assertEquals(67, q.dequeue());
		assertEquals(false, q.isEmpty());
		assertEquals(-3, q.dequeue());
		assertEquals(0, q.size());
		assertEquals(true, q.isEmpty());
	}

}
