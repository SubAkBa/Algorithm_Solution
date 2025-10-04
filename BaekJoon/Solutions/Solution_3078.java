import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3078 {
	public static long slidingWindow(int N, int K, String[] names) {
		long count = 0;
		int[] lenCounts = new int[21];

		for (int right = 0; right < K; ++right) {
			++lenCounts[names[right].length()];
		}

		for (int right = K, left = 0; left < N - 1; ++right, ++left) {
			if (right < N) {
				++lenCounts[names[right].length()];
			}

			--lenCounts[names[left].length()];
			count += lenCounts[names[left].length()];
		}

		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		String[] names = new String[N];
		for (int i = 0; i < N; ++i) {
			names[i] = br.readLine();
		}

		System.out.println(slidingWindow(N, K, names));
	}
}
