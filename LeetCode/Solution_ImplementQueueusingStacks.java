import java.util.*;

public class Solution_ImplementQueueusingStacks {
	public static class MyQueue {
		Stack<Integer> stack1;
		Stack<Integer> stack2;

		public MyQueue() {
			stack1 = new Stack<>();
			stack2 = new Stack<>();
		}

		/** Push element x to the back of queue. */
		public void push(int x) {
			stack1.push(x);
		}

		/** Removes the element from in front of queue and returns that element. */
		public int pop() {
			if (stack2.isEmpty()) {
				while (!stack1.isEmpty())
					stack2.push(stack1.pop());
			}

			return stack2.pop();
		}

		/** Get the front element. */
		public int peek() {
			if (stack2.isEmpty()) {
				while (!stack1.isEmpty())
					stack2.push(stack1.pop());
			}

			return stack2.peek();
		}

		/** Returns whether the queue is empty. */
		public boolean empty() {
			return stack1.isEmpty() && stack2.isEmpty();
		}
	}

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();

		queue.push(1);
		queue.push(2);
		System.out.println(queue.peek()); // returns 1
		System.out.println(queue.pop()); // returns 1
		System.out.println(queue.empty()); // returns false
	}
}
