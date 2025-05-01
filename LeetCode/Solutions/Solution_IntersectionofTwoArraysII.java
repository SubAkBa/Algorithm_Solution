import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_IntersectionofTwoArraysII {
	public static int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> n1Map = new HashMap<>();
		Map<Integer, Integer> n2Map = new HashMap<>();

		for (int n1 : nums1) {
			n1Map.put(n1, n1Map.getOrDefault(n1, 0) + 1);
		}

		for (int n2 : nums2) {
			n2Map.put(n2, n2Map.getOrDefault(n2, 0) + 1);
		}

		List<Integer> resultList = new ArrayList<>();

		for (int key : n1Map.keySet()) {
			int n1Count = n1Map.getOrDefault(key, 0);
			int n2Count = n2Map.getOrDefault(key, 0);

			int count = Math.min(n1Count, n2Count);

			while ((--count) >= 0) {
				resultList.add(key);
			}
		}

		int[] resultArray = new int[resultList.size()];
		for (int i = 0; i < resultList.size(); ++i) {
			resultArray[i] = resultList.get(i);
		}

		return resultArray;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(intersect(new int[] {1, 2, 2, 1}, new int[] {2, 2}))); // [2,2]
		System.out.println(Arrays.toString(intersect(new int[] {4, 9, 5}, new int[] {9, 4, 9, 8, 4}))); // [4,9]
		System.out.println(Arrays.toString(intersect(new int[] {1, 1, 1, 1}, new int[] {1, 1}))); // [1,1]
	}
}
