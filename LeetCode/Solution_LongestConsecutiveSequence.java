import java.util.*;

public class Solution_LongestConsecutiveSequence {
	static int[] parent, depth;

	public static void Init(int len) {
		for (int i = 0; i < len; ++i)
			parent[i] = i;
	}

	public static int Find(int u) {
		if (u == parent[u])
			return u;

		return parent[u] = Find(parent[u]);
	}

	public static void Swap(int a, int b) {
		int temp = depth[a];
		depth[a] = depth[b];
		depth[b] = temp;
	}

	public static void Union(int u, int v) {
		int uR = Find(u);
		int vR = Find(v);

		if (uR == vR)
			return;

		if (depth[uR] > depth[vR])
			Swap(uR, vR);

		parent[uR] = vR;

		if (depth[uR] == depth[vR])
			++depth[vR];
	}

	public static void Union_Task(int len, int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < len; ++i) {
			if (map.containsKey(nums[i]))
				continue;

			map.put(nums[i], i);

			if (map.containsKey(nums[i] + 1))
				Union(i, map.get(nums[i] + 1));

			if (map.containsKey(nums[i] - 1))
				Union(map.get(nums[i] - 1), i);
		}
	}

	public static int GetMaxLen(int len) {
		int maxlen = 0;
		int[] count = new int[len];

		for (int i = 0; i < len; ++i) {
			++count[Find(i)];
			maxlen = Math.max(count[Find(i)], maxlen);
		}

		return maxlen;
	}

	public static int longestConsecutive(int[] nums) {
		int len = nums.length;

		if (len == 0)
			return 0;

		parent = new int[len];
		depth = new int[len];

		Init(len);
		Union_Task(len, nums);

		return GetMaxLen(len);
	}

	public static void main(String[] args) {
		System.out.println(longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 })); // 4
		System.out.println(longestConsecutive(new int[] { 9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6 })); // 7
		System.out.println(longestConsecutive(new int[] {})); // 0
		System.out.println(longestConsecutive(new int[] { 0, -1 })); // 2
		System.out.println(longestConsecutive(new int[] { 9, 1, -3, 2, 4, 8, 3, -1, 6, -2, -4, 7 })); // 4
	}
}
