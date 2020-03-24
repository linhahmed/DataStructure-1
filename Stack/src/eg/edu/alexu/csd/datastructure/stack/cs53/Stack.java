package eg.edu.alexu.csd.datastructure.stack.cs53;

import java.util.Scanner;

/**
 * making a stack using linkedlist
 * 
 * @author linh
 *
 */
public class Stack implements IStack {
	/**
	 * the head of the linkedlist and size
	 */
	StackNode head;
	int size = 0;

	/**
	 * node pf the linkedlist
	 * 
	 * @author linh
	 */
	static class StackNode {
		Object data;
		StackNode next;

		StackNode(Object d) {
			this.data = d;
		}
	}

	/**
	 * Removes the element at the top of stack and returns that element.
	 *
	 * @return top of stack element, or through exception if empty
	 */
	public Object pop() {
		Object popped;
		if (head == null) {
			System.out.println("The Stack is empty.");
			return null;
		} else {
			popped = head.data;
			head = head.next;
			size--;
			return popped;
		}
	}

	/**
	 * Get the element at the top of stack without removing it from stack.
	 *
	 * @return top of stack element, or through exception if empty
	 */
	public Object peek() {
		if (head == null) {
			System.out.println("The Stack is empty.");
			return null;
		} else {
			return head.data;
		}
	}

	/**
	 * Pushes an item onto the top of this stack.
	 *
	 * @param object to insert
	 */
	public void push(Object element) {
		StackNode newNode = new StackNode(element);
		if (head == null) {
			head = newNode;
		} else {
			StackNode temp = head;
			head = newNode;
			newNode.next = temp;
		}
		size++;
	}

	/**
	 * Tests if this stack is empty
	 *
	 * @return true if stack empty
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * Returns the number of elements in the stack.
	 *
	 * @return number of elements in the stack
	 */
	public int size() {
		return size;
	}

	
}
