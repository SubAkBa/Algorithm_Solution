import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1654 {

	public static int binarySearch(int N, int[] lines, int maxLength) {
		int left = 0, right = maxLength;

		while (left < right) {
			int mid = left + ((right - left + 1) >>> 1);

			int count = 0;
			for (int line : lines) {
				count += line / mid;

				if (count >= N) {
					break;
				}
			}

			if (count >= N) {
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

		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int maxLength = 0;
		int[] lines = new int[K];

		for (int i = 0; i < K; ++i) {
			lines[i] = Integer.parseInt(br.readLine());
			maxLength = Math.max(maxLength, lines[i]);
		}

		System.out.println(binarySearch(N, lines, maxLength));
	}
}
