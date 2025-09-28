import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_16434 {

	public static long binarySearch(int N, int H, int[] t, long[] a, long[] h) {
		long left = 1, right = Long.MAX_VALUE, answer = 0;

		while (left <= right) {
			long mid = left + ((right - left) >>> 1);
			long damage = H, hp = mid;

			for (int i = 0; i < N; ++i) {
				if (t[i] == 1) {
					long hits = (h[i] + damage - 1) / damage;
					hp -= (hits - 1) * a[i];

					if (hp <= 0) {
						break;
					}
				} else if (t[i] == 2) {
					hp = Math.min(mid, h[i] + hp);
					damage += a[i];
				}
			}

			if (hp > 0) {
				right = mid - 1;
				answer = mid;
			} else {
				left = mid + 1;
			}
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[] t = new int[N];
		long[] a = new long[N];
		long[] h = new long[N];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());

			t[i] = Integer.parseInt(st.nextToken());
			a[i] = Long.parseLong(st.nextToken());
			h[i] = Long.parseLong(st.nextToken());
		}

		System.out.println(binarySearch(N, H, t, a, h));
	}
}
