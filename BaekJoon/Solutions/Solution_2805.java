import java.util.*;
import java.io.*;

public class Solution_2805 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long M = Long.parseLong(st.nextToken());

		long[] tree = new long[N];
		long max = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, tree[i]);
		}

		long answer = 0;
		long left = 0, right = max;

		while (left <= right) {
			long mid = (left + right) / 2;
			long total = 0;

			for (int i = 0; i < N; i++) {
				if (mid < tree[i])
					total += tree[i] - mid;
			}

			if (total >= M) {
				if (answer < mid)
					answer = mid;
				left = mid + 1;
			} else
				right = mid - 1;
		}

		bw.write(answer + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
