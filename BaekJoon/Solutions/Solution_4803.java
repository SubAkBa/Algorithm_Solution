import java.util.*;
import java.io.*;

public class Solution_4803 {
	static boolean isCycle;

	public static void DFS(int n, List<Integer>[] adj, boolean[] visited, int from, int prev) {
		visited[from] = true;

		for (int to : adj[from]) {
			if (visited[to]) {
				if (to != prev)
					isCycle = true;
				
				continue;
			}

			DFS(n, adj, visited, to, from);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = 0;
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			if (n == 0 && m == 0)
				break;

			List<Integer>[] adj = new ArrayList[n + 1];

			for (int i = 0; i <= n; ++i)
				adj[i] = new ArrayList<>();

			for (int i = 0; i < m; ++i) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				adj[a].add(b);
				adj[b].add(a);
			}

			int count = 0;
			boolean[] visited = new boolean[n + 1];
			for (int i = 1; i <= n; ++i) {
				if (visited[i])
					continue;

				isCycle = false;

				DFS(n, adj, visited, i, 0);

				if (!isCycle)
					++count;
			}

			bw.write("Case " + (++T) + ": ");
			if (count == 0)
				bw.write("No trees.\n");
			else if (count == 1)
				bw.write("There is one tree.\n");
			else
				bw.write("A forest of " + count + " trees.\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
