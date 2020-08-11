import java.util.*;

public class Solution_HIndex {

	public static int solution(int[] citations) {
		int answer = 0, len = citations.length;
		Arrays.sort(citations);

		for (int i = len - 1; i >= 0; i--)
			answer = Math.max(answer, Math.min(len - i, citations[i]));

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 3, 0, 6, 1, 5 }));
		System.out.println(solution(new int[] { 1, 2, 5, 4, 4 }));
		System.out.println(solution(new int[] { 4, 4, 4 }));
		System.out.println(solution(new int[] { 2, 7, 5 }));

	}

}
