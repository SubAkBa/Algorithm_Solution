import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3079 {

	public static long binarySearch(int M, int[] T, long maxT) {
		long left = 0, right = maxT * M;

		while (left < right) {
			long mid = left + ((right - left) >>> 1);
			long count = 0;

			for (int t : T) {
				count += mid / t;

				if (count >= M) {
					break;
				}
			}

			if (count >= M) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return right;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] T = new int[N];

		long maxT = 0;
		for (int i = 0; i < N; ++i) {
			T[i] = Integer.parseInt(br.readLine());

			maxT = Math.max(maxT, T[i]);
		}

		System.out.println(binarySearch(M, T, maxT));
	}
}
