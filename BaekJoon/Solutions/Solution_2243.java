import java.util.*;
import java.io.*;

public class Solution_2243 {
	static int LEN = 1000000, tree_len;
	static long result;

	public static int AllocSize(int n) {
		return (int) Math.pow(2, Math.ceil(Math.log(n) / Math.log(2)) + 1);
	}

	public static void Update(long[] tree, int start, int end, int idx, int node, long diff) {
		if (!(start <= idx && idx <= end))
			return;

		tree[node] += diff;

		if (start != end) {
			int mid = (start + end) / 2;

			Update(tree, start, mid, idx, node * 2, diff);
			Update(tree, mid + 1, end, idx, node * 2 + 1, diff);
		}
	}

	public static long Query(long[] tree, int start, int end, int K, int node) {
		if (start == end && result == 0)
			return result = start;

		int mid = (start + end) / 2;

		if (result == 0 && (node * 2 <= tree_len && tree[node * 2] >= K))
			return result = Query(tree, start, mid, K, node * 2);

		K -= tree[node * 2];

		if (result == 0 && (node * 2 + 1 <= tree_len && tree[node * 2 + 1] >= K))
			return result = Query(tree, mid + 1, end, K, node * 2 + 1);

		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		tree_len = AllocSize(LEN);
		long[] tree = new long[tree_len];

		result = 0;

		while ((n--) > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			switch (A) {
			case 1:
				long idx = Query(tree, 0, LEN - 1, B, 1);
				result = 0;
				bw.write(idx + "\n");

				Update(tree, 0, LEN - 1, (int) idx, 1, -1);
				break;
			case 2:
				int C = Integer.parseInt(st.nextToken());
				Update(tree, 0, LEN - 1, B, 1, C);
				break;
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
