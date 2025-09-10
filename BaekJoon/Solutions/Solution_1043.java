import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1043 {
	static int[] trueP;
	static int[] parent;
	static int[] size;
	static List<Integer>[] party;

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

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parent = new int[N + 1];
		size = new int[N + 1];
		party = new ArrayList[M];

		for (int i = 1; i <= N; ++i) {
			parent[i] = i;
			size[i] = 1;
		}

		st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken());
		trueP = new int[K];

		for (int i = 0; i < K; ++i) {
			trueP[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; ++i) {
			party[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());

			int partySize = Integer.parseInt(st.nextToken());

			for (int j = 0; j < partySize; ++j) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		for (int i = 0; i < M; ++i) {
			int first = party[i].get(0);

			for (int j = 1; j < party[i].size(); ++j) {
				union(first, party[i].get(j));
			}
		}

		int count = 0;
		for (int i = 0; i < M; ++i) {
			boolean isPossible = true;
			int current = party[i].get(0);

			for (int t : trueP) {
				if (find(current) == find(t)) {
					isPossible = false;
					break;
				}
			}

			if (isPossible) {
				++count;
			}
		}

		System.out.println(count);
	}
}
