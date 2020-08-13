import java.util.*;

public class Solution_LongestConsecutiveSequence {
	static int[] parent, depth;

	// 최초에 루트를 자기자신으로 설정
	public static void Init(int len) {
		for (int i = 0; i < len; ++i)
			parent[i] = i;
	}

	// 현재 자신이 속한 집합의 루트가 누구인지 
	public static int Find(int u) {
		if (u == parent[u])
			return u;

		return parent[u] = Find(parent[u]); // 경로 압축
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

		// 항상 깊이가 낮은 트리를 높은 트리에 붙이기 위해 (불균형 이진 트리 방지)
		if (depth[uR] > depth[vR])
			Swap(uR, vR);

		// 깊이가 상대적으로 얕은 uR을 vR 트리에 붙이기
		parent[uR] = vR;

		// 깊이가 동일하다면 한쪽 트리의 깊이를 하나 늘려준다. (마찬자기로 불균형 이진 트리를 방지하기 위한 과정)
		if (depth[uR] == depth[vR])
			++depth[vR];
	}

	// 값이 아닌 인덱스를 이용하여 Union연산
	public static void Union_Task(int len, int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < len; ++i) {
			if (map.containsKey(nums[i]))
				continue;

			map.put(nums[i], i); // {값 : 인덱스} 를 해시맵에 저장

			// 현재 값 + 1이 존재한다면 
			// nums[i]의 인덱스 : i
			// nums[i] + 1의 인덱스 : map.get(nums[i] + 1)
			// 두 인덱스 값을 Union
			if (map.containsKey(nums[i] + 1))
				Union(i, map.get(nums[i] + 1));

			// 현재 값 - 1이 존재한다면 
			// nums[i]의 인덱스 : i
			// nums[i] - 1의 인덱스 : map.get(nums[i] - 1)
			// 두 인덱스 값을 Union
			if (map.containsKey(nums[i] - 1))
				Union(map.get(nums[i] - 1), i);
		}
	}

	public static int GetMaxLen(int len) {
		int maxlen = 0;
		int[] count = new int[len];

		// 현재 속한 집합의 루트 갯수를 세어 가장 긴 연속적인 시퀀스를 찾기 
		for (int i = 0; i < len; ++i) {
			++count[Find(i)]; // 루트 개수 새기
			maxlen = Math.max(count[Find(i)], maxlen); // 최댓값 갱신
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
