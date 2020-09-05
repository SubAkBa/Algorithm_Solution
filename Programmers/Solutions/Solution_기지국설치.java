
public class Solution_기지국설치 {
	public static int solution(int n, int[] stations, int w) {
		int scount = stations.length;
		int range = 2 * w + 1, half_range = w + 1;

		int answer = 0;

		int diff = stations[0] - half_range;
		if (diff > 0)
			answer += (diff - 1) / range + 1;

		for (int i = 1; i < scount; ++i) {
			diff = stations[i] - stations[i - 1] - range;

			if (diff > 0)
				answer += (diff - 1) / range + 1;
		}

		diff = (n + 1) - stations[scount - 1] - half_range;

		if (diff > 0)
			answer += (diff - 1) / range + 1;

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(11, new int[] { 4, 11 }, 1)); // 3
		System.out.println(solution(16, new int[] { 9 }, 2)); // 3
		System.out.println(solution(1, new int[] { 1 }, 1)); // 0
	}
}
