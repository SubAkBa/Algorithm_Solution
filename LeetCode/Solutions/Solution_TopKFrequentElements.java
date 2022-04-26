import java.util.*;

public class Solution_TopKFrequentElements {
	
	// Stream 이용
	public static int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> table = new HashMap<>();

		for (int n : nums) {
		    table.put(n, table.getOrDefault(n, 0) + 1);
		}

		List<Integer> sortList = table.entrySet()
			.stream()
			.sorted((a, b) -> b.getValue().compareTo(a.getValue()))
			.map(Map.Entry::getKey)
			.collect(Collectors.toList());

		int[] answer = new int[k];
		for (int i = 0; i < k; ++i) {
		    answer[i] = sortList.get(i);
		}

		return answer;
	}

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
