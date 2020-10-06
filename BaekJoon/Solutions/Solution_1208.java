import java.util.*;
import java.io.*;

public class Solution_1208 {
	static long count;
	static int N;

	public static void Left_DFS(Map<Integer, Integer> table, int[] nums, int idx, int sum) {
		if (idx == N / 2) {
			table.put(sum, table.getOrDefault(sum, 0) + 1);
			return;
		}

		Left_DFS(table, nums, idx + 1, sum + nums[idx]);
		Left_DFS(table, nums, idx + 1, sum);
	}

	public static void Right_DFS(Map<Integer, Integer> table, int[] nums, int idx, int sum, int S) {
		if (idx == N) {
			count += table.getOrDefault(S - sum, 0);
			return;
		}

		Right_DFS(table, nums, idx + 1, sum + nums[idx], S);
		Right_DFS(table, nums, idx + 1, sum, S);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int[] nums = new int[N];
		for (int i = 0; i < N; ++i)
			nums[i] = Integer.parseInt(st.nextToken());

		count = 0;
		Map<Integer, Integer> table = new HashMap<>();

		Left_DFS(table, nums, 0, 0);
		Right_DFS(table, nums, N / 2, 0, S);

		bw.write((S == 0 ? count - 1 : count) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
