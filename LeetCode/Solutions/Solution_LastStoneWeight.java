import java.util.*;

public class Solution_LastStoneWeight {

	public static int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

		int len = stones.length;

		for (int i = 0; i < len; ++i)
			pq.offer(stones[i]);

		while (pq.size() > 1) {
			int y = pq.poll();
			int x = pq.poll();

			if (x < y)
				pq.offer(y - x);
		}

		return pq.isEmpty() ? 0 : pq.poll();
	}

	public static void main(String[] args) {
		System.out.println(lastStoneWeight(new int[] { 2, 7, 4, 1, 8, 1 })); // 1
		System.out.println(lastStoneWeight(new int[] { 2, 2 })); // 0
	}
}
