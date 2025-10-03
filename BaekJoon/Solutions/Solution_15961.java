import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_15961 {
	public static int slidingWindow(int N, int d, int k, int c, int[] sushi) {
		int left = 0, type = 1, maxType = 0;
		int[] count = new int[d + 1];
		++count[c];

		for (int right = 0; right < k; ++right) {
			if ((count[sushi[right]]++) == 0) {
				++type;
				++maxType;
			}
		}

		for (int right = k; right < 2 * N; ++right, ++left) {
			if ((--count[sushi[left % N]]) == 0) {
				--type;
			}

			if ((count[sushi[right % N]]++) == 0) {
				++type;
			}

			maxType = Math.max(maxType, type);
		}

		return maxType;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] sushi = new int[N];
		for (int i = 0; i < N; ++i) {
			sushi[i] = Integer.parseInt(br.readLine());
		}

		System.out.println(slidingWindow(N, d, k, c, sushi));
	}
}
