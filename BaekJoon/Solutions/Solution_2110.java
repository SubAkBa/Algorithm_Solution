import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2110 {

	public static int binarySearch(int C, int[] positions, int dist) {
		int left = 0, right = dist;

		while (left < right) {
			int mid = left + ((right - left + 1) >>> 1);
			int start = positions[0];
			int count = 1;

			for (int pos : positions) {
				if (mid <= pos - start) {
					start = pos;
					++count;
				}

				if (count >= C) {
					break;
				}
			}

			if (count >= C) {
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

		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int maxPos = 0;
		int[] positions = new int[N];

		for (int i = 0; i < N; ++i) {
			positions[i] = Integer.parseInt(br.readLine());
			maxPos = Math.max(positions[i], maxPos);
		}

		Arrays.sort(positions);

		System.out.println(binarySearch(C, positions, positions[N - 1] - positions[0]));
	}
}
