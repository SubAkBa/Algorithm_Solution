import java.util.*;
import java.io.*;

public class dfs_1260_solution {
	static int[][] graph;
	static boolean[] visited;
	static int N;

	public static void DFS(int start) {
		visited[start] = true;
		
		System.out.print(start + " ");
		
		for (int i = 1; i <= N; i++) {
			if (!visited[i] && graph[start][i] == 1)
				DFS(i);
		}
	}

	public static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<>();

		visited[start] = true;
		queue.offer(start);

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			System.out.print(cur + " ");

			for (int i = 1; i <= N; i++) {
				if (!visited[i] && graph[cur][i] == 1) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());

		graph = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			graph[from][to] = graph[to][from] = 1;
		}

		DFS(start);

		System.out.println();
		Arrays.fill(visited, false);

		BFS(start);
	}

}
