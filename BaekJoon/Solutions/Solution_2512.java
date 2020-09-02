import java.util.*;
import java.io.*;

public class Solution_2512 {
	static int N, M, max = 0;
	static int[] budgets;

	public static int BS() {
		int left = 0, right = max;
		int answer = 0;

		while (left <= right) {
			int mid = (left + right) / 2;
			int total = 0;

			for (int i = 0; i < N; i++)
				total += Math.min(mid, budgets[i]);

			if (total <= M) {
				answer = mid;
				left = mid + 1;
			} else
				right = mid - 1;
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		budgets = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			budgets[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, budgets[i]);
		}

		M = Integer.parseInt(br.readLine());

		bw.write(BS() + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
