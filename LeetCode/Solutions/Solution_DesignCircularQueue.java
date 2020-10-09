import java.util.*;

public class Solution_DesignCircularQueue {
	class MyCircularQueue {
		List<Integer> list;
		int count, k, last;

		/* Initialize your data structure here. Set the size of the queue to be k. */
		public MyCircularQueue(int k) {
			list = new LinkedList<>();
			count = 0;
			last = -1;
			this.k = k;
		}

		/*
		 * Insert an element into the circular queue. Return true if the operation is
		 * successful.
		 */
		public boolean enQueue(int value) {
			if (isFull())
				return false;

			++count;
			last = value;
			return list.add(value);
		}

		/*
		 * Delete an element from the circular queue. Return true if the operation is
		 * successful.
		 */
		public boolean deQueue() {
			if (isEmpty())
				return false;

			--count;
			list.remove(0);
			return true;
		}

		/* Get the front item from the queue. */
		public int Front() {
			if (isEmpty())
				return -1;

			return list.get(0);
		}

		/* Get the last item from the queue. */
		public int Rear() {
			if (isEmpty())
				return -1;

			return last;
		}

		/* Checks whether the circular queue is empty or not. */
		public boolean isEmpty() {
			return list.isEmpty();
		}

		/* Checks whether the circular queue is full or not. */
		public boolean isFull() {
			return (count == k);
		}
	}
}
