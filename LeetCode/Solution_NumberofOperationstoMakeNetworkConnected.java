import java.util.*;

public class Solution_NumberofOperationstoMakeNetworkConnected {

	public static void DFS(int start, boolean[] visited, List<Integer>[] adj) {
		visited[start] = true;

		for (int to : adj[start]) {
			if (visited[to])
				continue;

			DFS(to, visited, adj);
		}
	}

	public static int makeConnected(int n, int[][] connections) {
		boolean[] visited = new boolean[n];
		List<Integer>[] adj = new ArrayList[n];
		int clen = connections.length;

		if (clen < n - 1)
			return -1;

		for (int i = 0; i < n; ++i)
			adj[i] = new ArrayList<>();

		for (int i = 0; i < clen; ++i) {
			adj[connections[i][0]].add(connections[i][1]);
			adj[connections[i][1]].add(connections[i][0]);
		}

		int group = 0;
		for (int i = 0; i < n; ++i) {
			if (!visited[i]) {
				DFS(i, visited, adj);
				++group;
			}
		}

		return group - 1;
	}

	public static void main(String[] args) {
		System.out.println(makeConnected(4, new int[][] { { 0, 1 }, { 0, 2 }, { 1, 2 } })); // 1
		System.out.println(makeConnected(6, new int[][] { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 2 }, { 1, 3 } })); // 2
		System.out.println(makeConnected(6, new int[][] { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 2 } })); // -1
		System.out.println(makeConnected(5, new int[][] { { 0, 1 }, { 0, 2 }, { 3, 4 }, { 2, 3 } })); // 0
	}
}
