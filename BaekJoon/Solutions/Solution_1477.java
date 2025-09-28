import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1477 {

	public static int binarySearch(int M, int L, int[] positions) {
		int left = 1, right = L, answer = 0;

		while (left <= right) {
			int mid = left + ((right - left) >>> 1);
			int count = 0;

			for (int i = 1; i < positions.length; ++i) {
				count += (positions[i] - positions[i - 1] - 1) / mid;

				if (count > M) {
					break;
				}
			}

			if (count > M) {
				left = mid + 1;
			} else {
				right = mid - 1;
				answer = mid;
			}
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] positions = new int[N + 2];

		positions[0] = 0;
		if (N > 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < N + 1; ++i) {
				positions[i] = Integer.parseInt(st.nextToken());
			}
		}
		positions[N + 1] = L;

		Arrays.sort(positions);

		System.out.println(binarySearch(M, L, positions));
	}
}
