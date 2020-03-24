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

	/**
	 * UI
	 * 
	 * @author linh
	 */
	public static class main1 {
		public static void main(String[] args) {
			IStack s = new Stack();
			while (true) {
				System.out.println("Please choose an action you want to implement on the stack:\n");
				System.out.println("------------------------------------------------------------\n");
				System.out.println("1: Push\n");
				System.out.println("2: Pop\n");
				System.out.println("3: Peek\n");
				System.out.println("4: Get size\n");
				System.out.println("5: Check if empty\n");
				System.out.println("=============================================================\n");
				Scanner in = new Scanner(System.in);
				int input = in.nextInt();

				if (input == 1) {
					System.out.println("Enter the Object you want to Push.\n");
					Object element = in.next();
					s.push(element);
					System.out.println(element + " pushed to stack");
					System.out.println("=============================================================\n");
				} else if (input == 2) {
					Object popped = s.pop();
					System.out.println(popped + " popped from stack");
					System.out.println("=============================================================\n");
				} else if (input == 3) {
					Object top = s.peek();
					System.out.println(top + " is the top element in stack");
					System.out.println("=============================================================\n");
				} else if (input == 4) {
					int size = s.size();
					System.out.println("The size of the stack is" + size + "\n");
					System.out.println("=============================================================\n");
				} else if (input == 5) {
					boolean is = s.isEmpty();
					System.out.println(is + "\n");
					System.out.println("=============================================================\n");
				} else {
					if (input > 5 || input < 1) {
						System.out.println("Invalid Input.");
					}
				}
			}
		}
	}
}
