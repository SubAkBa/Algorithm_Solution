import java.util.*;
import java.io.*;

public class Solution_1182 {
	static int count = 0, N, S;
	static int[] nums;

	public static void Sum(int idx, int sum) {
		if (idx == N) {
			if (sum == S)
				count++;

			return;
		}

		Sum(idx + 1, sum);
		Sum(idx + 1, sum + nums[idx]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		nums = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(st.nextToken());

		Sum(0, 0);

		bw.write((S == 0 ? count - 1 : count) + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
