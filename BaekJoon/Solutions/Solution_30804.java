import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_30804 {

	public static int twoPointer(int N, int[] fruits) {
		int left = 0;
		int maxLen = 0, types = 0;
		int[] counts = new int[10];

		for (int right = 0; right < N; ++right) {
			if ((counts[fruits[right]]++) == 0) {
				++types;
			}

			while (types > 2) {
				if ((--counts[fruits[left]]) == 0) {
					--types;
				}

				++left;
			}

			maxLen = Math.max(maxLen, right - left + 1);
		}

		return maxLen;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] fruits = new int[N];
		for (int i = 0; i < N; ++i) {
			fruits[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(twoPointer(N, fruits));
	}
}
