import java.util.*;
import java.io.*;

public class aboutgraph_5567_solution {
	static int[][] graph;
	static int vertex, edge;
	static int[] visited;
	static int count = 0;

	public static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();

		visited[start] = 0;

		queue.offer(start);

		while (!queue.isEmpty()) {
			int from = queue.poll();

			for (int to = 1; to <= vertex; to++) {

				if (visited[to] == 0 && graph[from][to] == 1) {
					queue.offer(to);
					visited[to] = visited[from] + 1;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		vertex = Integer.parseInt(br.readLine());
		edge = Integer.parseInt(br.readLine());

		graph = new int[vertex + 1][vertex + 1];
		visited = new int[vertex + 1];

		for (int[] arr : graph)
			Arrays.fill(arr, 0);

		Arrays.fill(visited, 0);

		for (int i = 1; i <= edge; i++) {
			String[] infos = br.readLine().split(" ");

			int from = Integer.parseInt(infos[0]);
			int to = Integer.parseInt(infos[1]);

			graph[from][to] = 1;
			graph[to][from] = 1;
		}

		BFS(1);

		for (int i = 2; i <= vertex; i++) {
			if (visited[i] == 1 || visited[i] == 2)
				count++;
		}

		System.out.println(count);
	}

}
