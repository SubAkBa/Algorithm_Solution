import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1717 {
	static int[] parent;
	static int[] size;

	public static int find(int node) {
		if (node == parent[node]) {
			return node;
		}
		return parent[node] = find(parent[node]);
	}

	public static void union(int a, int b) {
		int aParent = find(a);
		int bParent = find(b);

		if (aParent == bParent) {
			return;
		}

		if (size[aParent] < size[bParent]) {
			parent[aParent] = bParent;
		} else if (size[aParent] > size[bParent]) {
			parent[bParent] = aParent;
		} else {
			parent[bParent] = aParent;
			++size[aParent];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n + 1];
		size = new int[n + 1];

		for (int i = 1; i <= n; ++i) {
			parent[i] = i;
			size[i] = 1;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (x == 1) {
				sb.append(find(a) == find(b) ? "YES\n" : "NO\n");
			} else {
				union(a, b);
			}
		}

		System.out.println(sb);
	}
}
