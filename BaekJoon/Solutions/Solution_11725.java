import java.util.*;
import java.io.*;

public class Solution_11725 {

	public static void DFS(int N, List<Integer>[] adj, int[] parent, boolean[] visited, int prev, int current) {
		parent[current] = prev;
		visited[current] = true;

		for (int to : adj[current]) {
			if (visited[to])
				continue;

			DFS(N, adj, parent, visited, current, to);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		List<Integer>[] adj = new ArrayList[N + 1];

		for (int i = 1; i <= N; ++i)
			adj[i] = new ArrayList<>();

		for (int i = 1; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			adj[A].add(B);
			adj[B].add(A);
		}

		int[] parent = new int[N + 1];

		DFS(N, adj, parent, new boolean[N + 1], 1, 1);

		for (int i = 2; i <= N; ++i)
			bw.write(parent[i] + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
}
