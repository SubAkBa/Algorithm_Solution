import java.util.*;

public class Solution_IntersectionofTwoArrays {

	public static int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> s1 = new HashSet<>();
		HashSet<Integer> intersect = new HashSet<>();

		int len1 = nums1.length, len2 = nums2.length;

		for (int i = 0; i < len1; i++)
			s1.add(nums1[i]);

		for (int i = 0; i < len2; i++) {
			if (s1.contains(nums2[i]))
				intersect.add(nums2[i]);
		}

		int[] answer = new int[intersect.size()];

		int idx = 0;
		for (Integer n : intersect)
			answer[idx++] = n;

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(intersection(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 })));
		System.out.println(Arrays.toString(intersection(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 })));
	}

}
