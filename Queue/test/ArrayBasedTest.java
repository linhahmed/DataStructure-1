package eg.edu.alexu.csd.datastructure.queue.cs1_cs53;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayBasedTest {
	@Test
	void test() {
		IArrayBased Q = new ArrayBased(5);
		Q.enqueue(1);
		Q.enqueue(2);
		Q.enqueue(3);
		Q.enqueue(4);
		Q.enqueue(5);
		assertEquals(5, Q.size());
		assertEquals(1, Q.dequeue());
		assertEquals(2, Q.dequeue());
		assertEquals(3, Q.size());
		assertEquals(false, Q.isEmpty());
		assertEquals(3, Q.dequeue());
		assertEquals(4, Q.dequeue());
		assertEquals(5, Q.dequeue());
		assertEquals(true, Q.isEmpty());

	}

}
