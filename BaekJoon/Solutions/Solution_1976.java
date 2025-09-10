import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1976 {
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
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		parent = new int[N + 1];
		size = new int[N + 1];

		for (int i = 1; i <= N; ++i) {
			parent[i] = i;
			size[i] = 1;
		}

		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= N; ++j) {
				int value = Integer.parseInt(st.nextToken());

				if (value == 1) {
					union(i, j);
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		int root1 = find(Integer.parseInt(st.nextToken()));
		int root2 = -1;
		for (int i = 2; i <= M; ++i) {
			root2 = find(Integer.parseInt(st.nextToken()));
			if (root1 != root2) {
				break;
			}
		}

		System.out.println(root1 == root2 ? "YES" : "NO");
	}
}
