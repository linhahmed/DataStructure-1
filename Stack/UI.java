package eg.edu.alexu.csd.datastructure.stack.cs53;

import java.util.Scanner;

public class UI {
	/**
	 * UI
	 * 
	 * @author linh
	 */

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
