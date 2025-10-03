import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_21921 {

	public static long[] slidingWindow(int N, int X, int[] count) {
		int left = 0;
		long maxCount = 0, periodCount = 1;

		for (int right = 0; right < X; ++right) {
			maxCount += count[right];
		}

		long sum = maxCount;
		for (int right = X; right < N; ++right, ++left) {
			sum += count[right] - count[left];

			if (maxCount == sum) {
				++periodCount;
			} else if (maxCount < sum) {
				periodCount = 1;
				maxCount = sum;
			}
		}

		return new long[]{maxCount, periodCount};
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[] count = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			count[i] = Integer.parseInt(st.nextToken());
		}

		long[] answer = slidingWindow(N, X, count);
		if (answer[0] == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(answer[0] + "\n" + answer[1]);
		}
	}
}
