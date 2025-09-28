import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_16401 {

	public static long binarySearch(int M, int[] cookies, long maxCookie) {
		if (maxCookie == 0) {
			return 0;
		}

		long left = 0, right = maxCookie;

		while (left < right) {
			long mid = left + ((right - left + 1) >>> 1);
			long count = 0;

			for (int cookie : cookies) {
				count += cookie / mid;

				if (count >= M) {
					break;
				}
			}

			if (count >= M) {
				left = mid;
			} else {
				right = mid - 1;
			}
		}

		return left;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] cookies = new int[N];

		long maxCookie = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			cookies[i] = Integer.parseInt(st.nextToken());
			maxCookie = Math.max(maxCookie, cookies[i]);
		}

		System.out.println(binarySearch(M, cookies, maxCookie));
	}
}
