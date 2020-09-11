import java.util.*;

public class Solution_TopKFrequentElements {

	public static int[] topKFrequent(int[] nums, int k) {
		int len = nums.length;
		Map<Integer, Integer> cache = new HashMap<>();

		for (int i = 0; i < len; ++i)
			cache.put(nums[i], cache.getOrDefault(nums[i], 0) + 1);

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

		for (int key : cache.keySet())
			pq.offer(new int[] { key, cache.get(key) });

		int[] answer = new int[k];
		int idx = 0;
		while ((--k) >= 0)
			answer[idx++] = pq.poll()[0];

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2))); // [1, 2]
		System.out.println(Arrays.toString(topKFrequent(new int[] { 1 }, 1))); // [1]
	}
}
