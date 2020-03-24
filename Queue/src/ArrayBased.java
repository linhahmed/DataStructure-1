package eg.edu.alexu.csd.datastructure.queue.cs1_cs53;

public class ArrayBased implements IArrayBased {
	private int size = 0;
	private int n, front, rear;
	Object Q[];

	ArrayBased(int n) {
		this.n = n;
		Q = new Object[n];
		front = 0;
		rear = 0;
	}

	public void enqueue(Object item) {
		try {
			Q[rear] = item;
			if (rear == n - 1) {
				rear = 0;
			} else {
				rear++;
			}
			size++;
		} catch (Exception e) {
			System.out.println("The Queue is full.");
		}

	}

	public Object dequeue() {
		Object data = Q[0];
		try {
			for (int i = 0; i < size - 1; i++) {
				Q[i] = Q[i + 1];
			}
			rear = size - 1;
			Q[size - 1] = null;
			size--;
		} catch (Exception e) {
			System.out.println("The Queue is Empty.");
		}
		return data;

	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

}
