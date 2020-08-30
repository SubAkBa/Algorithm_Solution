import java.util.*;

public class Solution_largestnumber {

	public static String solution(int[] numbers) {
		int len = numbers.length;
		StringBuilder sb = new StringBuilder();
		String[] nstr = new String[len];

		for (int i = 0; i < len; ++i)
			nstr[i] = Integer.toString(numbers[i]);

		Arrays.sort(nstr, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return (s2 + s1).compareTo(s1 + s2);
			}
		});

		if (nstr[0].equals("0"))
			return "0";

		for (int i = 0; i < len; ++i)
			sb.append(nstr[i]);

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 6, 10, 2 }));
		System.out.println(solution(new int[] { 3, 30, 34, 5, 9 }));
	}
}
