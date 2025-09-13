import java.util.*;
import java.io.*;

public class Solution_1948 {
	static int[] costs;

	public static class Edge {
		int to, dist;

		public Edge(int to, int dist) {
			this.to = to;
			this.dist = dist;
		}
	}

	public static void topologicalSort(int start, List<Edge>[] adjList, int[] inDeg) {
		Queue<Edge> queue = new ArrayDeque<>();

		queue.offer(new Edge(start, 0));

		while (!queue.isEmpty()) {
			Edge current = queue.poll();

			for (Edge next : adjList[current.to]) {
				--inDeg[next.to];

				costs[next.to] = Math.max(costs[next.to], costs[current.to] + next.dist);

				if (inDeg[next.to] == 0) {
					queue.offer(new Edge(next.to, next.dist));
				}
			}
		}
	}

	public static int reverseTopologicalSort(int n, int end, List<Edge>[] revAdjList) {
		Queue<Edge> queue = new ArrayDeque<>();
		int count = 0;
		boolean[] visited = new boolean[n + 1];

		queue.offer(new Edge(end, 0));

		while (!queue.isEmpty()) {
			Edge current = queue.poll();

			for (Edge next : revAdjList[current.to]) {
				if (costs[current.to] == costs[next.to] + next.dist) {
					++count;

					if (!visited[next.to]) {
						queue.offer(new Edge(next.to, next.dist));
						visited[next.to] = true;
					}
				}
			}
		}

		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		List<Edge>[] adjList = new ArrayList[n + 1];
		List<Edge>[] revAdjList = new ArrayList[n + 1];
		int[] inDeg = new int[n + 1];
		costs = new int[n + 1];

		for (int i = 1; i <= n; ++i) {
			adjList[i] = new ArrayList<>();
			revAdjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			adjList[a].add(new Edge(b, c));
			revAdjList[b].add(new Edge(a, c));
			++inDeg[b];
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		topologicalSort(start, adjList, inDeg);

		System.out.println(costs[end]);
		System.out.println(reverseTopologicalSort(n, end, revAdjList));
	}
}
