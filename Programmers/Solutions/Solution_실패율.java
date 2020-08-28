import java.util.*;

public class Solution_실패율 {

	public static int[] solution(int N, int[] stages) {
		int slen = stages.length;
		int[] counts = new int[N + 2];

		for (int i = 0; i < slen; ++i)
			++counts[stages[i]];

		for (int i = 1; i < N + 2; ++i)
			counts[i] += counts[i - 1];

		double[][] fail = new double[N + 1][2];

		for (int i = 1; i <= N; ++i) {
			if (counts[N + 1] == counts[i - 1])
				fail[i][0] = 0;
			else
				fail[i][0] = (double) (counts[i] - counts[i - 1]) / (counts[N + 1] - counts[i - 1]);
			fail[i][1] = i;
		}

		Arrays.sort(fail, 1, N + 1, (a, b) -> (a[0] == b[0] ? Double.compare(a[1], b[1]) : Double.compare(b[0], a[0])));

		int[] answer = new int[N];

		for (int i = 1; i <= N; ++i)
			answer[i - 1] = (int) fail[i][1];

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(5, new int[] { 2, 1, 2, 6, 2, 4, 3, 3 }))); // [3, 4, 2, 1, 5]
		System.out.println(Arrays.toString(solution(4, new int[] { 4, 4, 4, 4, 4 }))); // [4, 1, 2, 3]
		System.out.println(Arrays.toString(solution(5, new int[] { 1, 2, 3, 4 }))); // [4, 3, 2, 1, 5]
	}
}
