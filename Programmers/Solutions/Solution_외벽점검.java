import java.util.*;

public class Solution_외벽점검 {
	static int answer, dlen, wlen, N;
	static int[][] rotateWeak;

	public static int[][] GetRotateWeak(int[] weak) {
		int[][] temp = new int[wlen][wlen];

		temp[0] = weak.clone();
		for (int i = 1; i < wlen; ++i) {
			int w = weak[0];

			for (int j = 1; j < wlen; ++j)
				weak[j - 1] = weak[j];

			weak[wlen - 1] = w + N;
			temp[i] = weak.clone();
		}

		return temp;
	}

	public static void Permutation(int[] dist, List<Integer> permu, int key, int idx) {
		if (answer == 1)
			return;

		if (permu.size() == dlen) {
			for (int[] rweak : rotateWeak) {
				int w = 0, i;

				for (i = 0; i < dlen; ++i) {
					int prev = rweak[w];
					while (w < wlen && rweak[w] <= prev + permu.get(i))
						++w;

					if (w == wlen) {
						if (answer == -1 || i + 1 < answer)
							answer = i + 1;
						break;
					}
				}
			}

			return;
		}

		if (idx == dlen)
			return;

		for (int i = 0; i < dlen; ++i) {
			if ((key & (1 << i)) != 0)
				continue;

			permu.add(dist[i]);
			key ^= (1 << i);

			Permutation(dist, permu, key, i);

			permu.remove(permu.size() - 1);
			key ^= (1 << i);
		}
	}

	public static int solution(int n, int[] weak, int[] dist) {
		answer = -1;
		wlen = weak.length;
		dlen = dist.length;
		N = n;

		rotateWeak = GetRotateWeak(weak);
		Permutation(dist, new ArrayList<>(), 0, 0);

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(2, new int[] { 1 }, new int[] { 1 })); // 1
		System.out.println(solution(12, new int[] { 1, 5, 6, 10 }, new int[] { 1, 2, 3, 4 })); // 2
		System.out.println(solution(12, new int[] { 1, 3, 4, 9, 10 }, new int[] { 3, 5, 7 })); // 1
		System.out.println(solution(30, new int[] { 1, 3, 4, 9, 10, 15, 25 }, new int[] { 3, 5, 7 })); // 3?
		System.out.println(solution(200, new int[] { 0, 10, 50, 80, 120, 160 }, new int[] { 1, 10, 5, 40, 30 })); // 3
		System.out.println(
				solution(200, new int[] { 0, 10, 20, 30, 50, 80, 120, 160 }, new int[] { 1, 1, 10, 5, 40, 30 })); // 4
	}
}
