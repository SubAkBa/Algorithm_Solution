import java.util.*;
import java.io.*;

public class Solution_1395 {

	public static int AllocSize(int n) {
		return (int) Math.pow(2, Math.ceil(Math.log(n) / Math.log(2)) + 1);
	}

	public static void Update_Lazy(long[] tree, long[] lazy, int start, int end, int node) {

		if (lazy[node] != 0) {
			tree[node] = (end - start + 1) - tree[node];

			if (start != end) {
				lazy[node * 2] ^= lazy[node];
				lazy[node * 2 + 1] ^= lazy[node];
			}

			lazy[node] = 0;
		}
	}

	public static void Update_Range(long[] tree, long[] lazy, int start, int end, int left, int right, int node) {
		Update_Lazy(tree, lazy, start, end, node);

		if (right < start || left > end)
			return;

		if (left <= start && end <= right) {
			lazy[node] ^= 1;
			Update_Lazy(tree, lazy, start, end, node);
			return;
		}

		int mid = (start + end) / 2;
		Update_Range(tree, lazy, start, mid, left, right, node * 2);
		Update_Range(tree, lazy, mid + 1, end, left, right, node * 2 + 1);

		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}

	public static long Query(long[] tree, long[] lazy, int start, int end, int left, int right, int node) {
		Update_Lazy(tree, lazy, start, end, node);

		if (right < start || left > end)
			return 0;

		if (left <= start && end <= right)
			return tree[node];

		int mid = (start + end) / 2;

		return Query(tree, lazy, start, mid, left, right, node * 2)
				+ Query(tree, lazy, mid + 1, end, left, right, node * 2 + 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int size = AllocSize(N);
		long[] lazy = new long[size];
		long[] tree = new long[size];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int O = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());

			switch (O) {
			case 0:
				Update_Range(tree, lazy, 0, N - 1, S - 1, T - 1, 1);
				break;
			case 1:
				bw.write(Query(tree, lazy, 0, N - 1, S - 1, T - 1, 1) + "\n");
				break;
			}

		}

		bw.flush();
		bw.close();
		br.close();
	}

}
