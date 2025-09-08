import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1325 {
	public static void bfs(int start, int visitId, List<Integer>[] adjList, int[] dist, int[] seen) {
		Queue<Integer> queue = new ArrayDeque<>();
		int count = 0;

		queue.offer(start);
		seen[start] = visitId;

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int next : adjList[current]) {
				if (seen[next] != visitId) {
					seen[next] = visitId;
					queue.offer(next);
					++count;
				}
			}
		}

		dist[start] = count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer>[] adj = new ArrayList[N + 1];
		int[] dist = new int[N + 1];
		int[] seen = new int[N + 1];

		for (int i = 1; i <= N; ++i) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			adj[B].add(A);
		}

		int visitId = 0;
		for (int i = 1; i <= N; ++i) {
			++visitId;
			bfs(i, visitId, adj, dist, seen);
		}

		int maxDist = 0;
		for (int i = 1; i <= N; ++i) {
			maxDist = Math.max(maxDist, dist[i]);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; ++i) {
			if (maxDist == dist[i]) {
				sb.append(i + " ");
			}
		}

		System.out.println(sb);
	}
}
