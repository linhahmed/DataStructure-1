package eg.edu.alexu.csd.datastructure.queue.cs1_cs53;

public class LinkedBased implements ILinkedBased {

	Node head;

	static class Node {
		Object data;
		Node next;

		Node(Object d) {
			data = d;
			next = null;
		}
	}

	public void enqueue(Object item) {
		Node n = new Node(item);
		if (head == null)
			head = n;
		else {
			Node current = head;
			while (current.next != null)
				current = current.next;
			current.next = n;
			n.next = null;
		}
	}

	public Object dequeue() {
		Node n;
		Object a = null;
		try {
			n = head.next;
			a = head.data;
			head.next = null;
			head = n;
		} catch (Exception e) {
			System.out.println("The Queue is Empty.");
		}
		return a;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public int size() {
		Node current = head;
		int s = 0;
		while (current != null) {
			s++;
			current = current.next;
		}
		return s;
	}

}
