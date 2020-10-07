import java.util.*;
import java.io.*;

public class Solution_2517 {

	public static void Update(int[] tree, int idx, int len) {
		while (idx < len) {
			++tree[idx];
			idx += (idx & -idx);
		}
	}

	public static int Query(int[] tree, int idx) {
		int result = 0;

		while (idx > 0) {
			result += tree[idx];
			idx -= (idx & -idx);
		}

		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		int[] nums = new int[N + 1];
		for (int i = 1; i <= N; ++i)
			nums[i] = Integer.parseInt(br.readLine());

		int[] sorted_nums = Arrays.copyOf(nums, N + 1);
		Arrays.sort(sorted_nums);

		Map<Integer, Integer> num2idx = new HashMap<>();
		for (int i = N; i >= 1; --i)
			num2idx.put(sorted_nums[i], (N - i + 1));

		int[] tree = new int[N + 1];
		for (int i = 1; i <= N; ++i) {
			bw.write((Query(tree, num2idx.get(nums[i])) + 1) + "\n");
			Update(tree, num2idx.get(nums[i]), N + 1);
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
