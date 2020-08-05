import java.util.*;

public class Solution_stepstones {

	public static int solution(int distance, int[] rocks, int n) {
		Arrays.sort(rocks);

		int len = rocks.length;
		int left = 1, right = distance, answer = 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			int count = 0, prev = 0;
			for (int i = 0; i < len; ++i) {
				int dist = rocks[i] - prev;

				if (dist < mid)
					++count;
				else
					prev = rocks[i];
			}

			if (distance - prev < mid)
				++count;

			if (count <= n) {
				left = mid + 1;
				answer = mid;
			} else
				right = mid - 1;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(25, new int[] { 2, 14, 11, 21, 17 }, 2));
		System.out.println(solution(16, new int[] { 4, 8, 11 }, 2));
	}
}
