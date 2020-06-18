import java.util.*;

public class Solution_LargestNumber {

	public static String largestNumber(int[] nums) {
		int len = nums.length;

		if (len == 0)
			return "0";

		String[] str = new String[len];
		for (int i = 0; i < len; i++)
			str[i] = Integer.toString(nums[i]);

		Arrays.sort(str, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return (s2 + s1).compareTo(s1 + s2);
			}
		});

		if (str[0].equals("0"))
			return "0";

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++)
			sb.append(str[i]);

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(largestNumber(new int[] { 10, 2 }));
		System.out.println(largestNumber(new int[] { 3, 30, 34, 5, 9 }));
		System.out.println(largestNumber(new int[] { 20, 1 }));
		System.out.println(largestNumber(new int[] { 0, 0, 0, 0 }));
		System.out.println(largestNumber(new int[] {}));
	}
}
