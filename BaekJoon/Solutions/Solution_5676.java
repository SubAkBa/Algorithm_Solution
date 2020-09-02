import java.util.*;
import java.io.*;

public class Solution_5676 {

	public static int AllocSize(int N) {
		return (int) Math.pow(2, Math.ceil(Math.log(N) / Math.log(2)) + 1);
	}

	public static int Update(int[] tree, int start, int end, int idx, int node, int diff) {
		if (!(start <= idx && idx <= end))
			return tree[node];

		if (start == end)
			return tree[node] = diff;

		int mid = (start + end) / 2;

		return tree[node] = Update(tree, start, mid, idx, node * 2, diff)
				* Update(tree, mid + 1, end, idx, node * 2 + 1, diff);
	}

	public static int Query(int[] tree, int start, int end, int left, int right, int node) {
		if (right < start || left > end)
			return 1;

		if (left <= start && end <= right)
			return tree[node];

		int mid = (start + end) / 2;

		return Query(tree, start, mid, left, right, node * 2) * Query(tree, mid + 1, end, left, right, node * 2 + 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = "";

		while ((str = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(str);

			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[] tree = new int[AllocSize(N)];

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());

				if (num > 0)
					Update(tree, 0, N - 1, i, 1, 1);
				else if (num < 0)
					Update(tree, 0, N - 1, i, 1, -1);
				else
					Update(tree, 0, N - 1, i, 1, 0);
			}

			while ((K--) > 0) {
				st = new StringTokenizer(br.readLine());

				String C = st.nextToken();
				int i = Integer.parseInt(st.nextToken()) - 1;

				switch (C) {
				case "C":
					int V = Integer.parseInt(st.nextToken());

					if (V > 0)
						Update(tree, 0, N - 1, i, 1, 1);
					else if (V < 0)
						Update(tree, 0, N - 1, i, 1, -1);
					else
						Update(tree, 0, N - 1, i, 1, 0);

					break;
				case "P":
					int j = Integer.parseInt(st.nextToken()) - 1;

					int result = Query(tree, 0, N - 1, i, j, 1);

					if (result > 0)
						bw.write("+");
					else if (result < 0)
						bw.write("-");
					else
						bw.write("0");
					break;
				}
			}

			bw.newLine();
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
