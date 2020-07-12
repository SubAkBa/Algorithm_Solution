import java.util.*;
import java.io.*;

public class Solution_2311 {
	static int N, M, INF = 987654321;
	static ArrayList<Edge>[] adj;

	public static int Travel(int source, int sink) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] inQ = new boolean[N + 2];
		int[] dist = new int[N + 2];
		int[] prev = new int[N + 2];
		Edge[] path = new Edge[N + 2];
		int total = 0;

		while (true) {
			for (int i = 0; i <= N + 1; i++)
				path[i] = new Edge();

			Arrays.fill(dist, INF);
			Arrays.fill(prev, -1);
			Arrays.fill(inQ, false);

			queue.offer(source);
			dist[source] = 0;
			inQ[source] = true;

			while (!queue.isEmpty()) {
				int from = queue.poll();

				inQ[from] = false;

				for (Edge to : adj[from]) {
					if (to.isRemain() && dist[to.idx] > dist[from] + to.cost) {
						dist[to.idx] = dist[from] + to.cost;
						prev[to.idx] = from;
						path[to.idx] = to;

						if (!inQ[to.idx]) {
							queue.offer(to.idx);
							inQ[to.idx] = true;
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

	public static void addEdge(int from, int to, int capacity, int cost) {
		Edge e1 = new Edge(to, capacity, cost);
		Edge e2 = new Edge(from, 0, -cost);

		e1.rev = e2;
		e2.rev = e1;

		adj[from].add(e1);
		adj[to].add(e2);
	}

	public static class Edge {
		int idx, capacity, flow, cost;
		Edge rev;

		public Edge() {
			this.idx = -1;
			this.capacity = 0;
			this.flow = 0;
			this.cost = 0;
		}

		public Edge(int idx, int capacity, int cost) {
			this.idx = idx;
			this.capacity = capacity;
			this.flow = 0;
			this.cost = cost;
			this.rev = null;
		}

		public boolean isRemain() {
			if (this.capacity - this.flow > 0)
				return true;

			return false;
		}

		public void CalcFlow() {
			++this.flow;
			--this.rev.flow;
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

		addEdge(0, 1, 2, 0);
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());

			int P = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			addEdge(P, Q, 1, L);
			addEdge(Q, P, 1, L);
		}
		addEdge(N, N + 1, 2, 0);

		bw.write(Travel(0, N + 1) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
