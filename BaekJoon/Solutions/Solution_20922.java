import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_20922 {

	public static int twoPointer(int N, int K, int[] a, int maxValue) {
		int left = 0;
		int maxLen = 0;
		int[] counts = new int[maxValue + 1];

		for (int right = 0; right < N; ++right) {
			++counts[a[right]];

			while (counts[a[right]] > K) {
				--counts[a[left]];
				++left;
			}

			maxLen = Math.max(maxLen, right - left + 1);
		}

		return maxLen;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int maxValue = 0;

		int[] a = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			a[i] = Integer.parseInt(st.nextToken());
			maxValue = Math.max(maxValue, a[i]);
		}

		System.out.println(twoPointer(N, K, a, maxValue));
	}
}
