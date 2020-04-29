import java.util.*;

public class Solution_secretmap {

	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];

		for (int i = 0; i < n; i++) {
			long temp = arr1[i] | arr2[i];
			String f = "%" + n + "s";
			String s = String.format(f, Long.toBinaryString(temp));

			answer[i] = s.replace("0", " ").replace("1", "#");
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(
				Arrays.toString(solution(5, new int[] { 9, 20, 28, 18, 11 }, new int[] { 30, 1, 21, 17, 28 })));
		System.out.println(Arrays
				.toString(solution(6, new int[] { 46, 33, 33, 22, 31, 50 }, new int[] { 27, 56, 19, 14, 14, 10 })));
	}

}
