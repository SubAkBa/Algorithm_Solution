import java.util.*;
import java.io.*;

public class Solution_1650 {
	static int N, M, INF = 987654321;
	static ArrayList<Edge>[] adj;

	public static int Terror_Season_II(int source, int sink) {
		int total = 0;
		Queue<Integer> queue = new LinkedList<>();
		Edge[] path = new Edge[N + 2];
		boolean[] inQ = new boolean[N + 2];
		int[] prev = new int[N + 2];
		int[] dist = new int[N + 2];

		while (true) {
			for (int i = 0; i <= N + 1; ++i)
				path[i] = new Edge();

			Arrays.fill(dist, INF);
			Arrays.fill(prev, -1);
			Arrays.fill(inQ, false);

			queue.offer(source);
			inQ[source] = true;
			dist[source] = 0;

			while (!queue.isEmpty()) {
				int from = queue.poll();

				inQ[from] = false;

				for (Edge to : adj[from]) {
					if (to.RemainFlow() && dist[to.idx] > dist[from] + to.cost) {
						dist[to.idx] = dist[from] + to.cost;
						prev[to.idx] = from;
						path[to.idx] = to;

						if (!inQ[to.idx]) {
							inQ[to.idx] = true;
							queue.offer(to.idx);
						}
					}
				}
			}

			if (prev[sink] == -1)
				break;

			for (int i = sink; i != source; i = prev[i]) {
				total += path[i].cost;
				path[i].CalcFlow();
			}
		}

		return total;
	}

	public static void addEdge(int from, int to, int cost, int capacity) {
		Edge edge1 = new Edge(to, cost, capacity);
		Edge edge2 = new Edge(from, -cost, 0);
		edge1.rev = edge2;
		edge2.rev = edge1;

		adj[from].add(edge1);
		adj[to].add(edge2);
	}

	public static class Edge {
		int idx, cost, capacity, flow;
		Edge rev;

		public Edge() {
			this.idx = -1;
			this.cost = 0;
			this.capacity = 0;
			this.flow = 0;
		}

		public Edge(int idx, int cost, int capacity) {
			this.idx = idx;
			this.cost = cost;
			this.capacity = capacity;
			this.flow = 0;
			this.rev = null;
		}

		public void CalcFlow() {
			++this.flow;
			--this.rev.flow;
		}

		public boolean RemainFlow() {
			if (this.capacity - this.flow > 0)
				return true;

			return false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N + 2];

		for (int i = 0; i <= N + 1; ++i)
			adj[i] = new ArrayList<>();

		addEdge(0, 1, 0, 2);
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());

			int P = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			addEdge(P, Q, L, 1);
			addEdge(Q, P, L, 1);
		}
		addEdge(N, N + 1, 0, 2);

		bw.write(Terror_Season_II(0, N + 1) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}