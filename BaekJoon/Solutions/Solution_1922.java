import java.util.*;
import java.io.*;

public class Solution_1922 {
	static int V, E;
	static Graph graph;
	static boolean[] visited;

	public static int NetworkMST(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		Queue<Integer> q = new LinkedList<>();
		int mincost = 0;

		q.offer(start);

		while (!q.isEmpty()) {
			int from = q.poll();
			visited[from] = true;

			for (Edge edge : graph.edge[from]) {
				if (!visited[edge.to]) {
					pq.offer(edge);
				}
			}

			while (!pq.isEmpty()) {
				Edge edge = pq.poll();

				if (!visited[edge.to]) {
					q.add(edge.to);
					visited[edge.to] = true;
					mincost += edge.cost;
					break;
				}
			}
		}

		return mincost;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());

		visited = new boolean[V + 1];
		graph = new Graph(V);

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph.addEdge(from, to, cost);
		}

		bw.write(NetworkMST(1) + " ");

		bw.flush();
		bw.close();
		br.close();
	}

	public static class Graph {
		List<Edge>[] edge;

		public Graph(int V) {
			edge = new LinkedList[V + 1];

			for (int i = 1; i <= V; i++)
				edge[i] = new LinkedList<>();
		}

		public void addEdge(int from, int to, int cost) {
			edge[from].add(new Edge(from, to, cost));
			edge[to].add(new Edge(to, from, cost));
		}
	}

	public static class Edge implements Comparable<Edge> {
		int from, to, cost;

		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge e) {
			return this.cost - e.cost;
		}

	}

}
