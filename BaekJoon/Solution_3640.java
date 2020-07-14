import java.util.*;
import java.io.*;

public class Solution_3640 {
	static ArrayList<Edge>[] adj;
	static int v, e, INF = 987654321;

	public static int MCMF(int source, int sink) {
		Queue<Integer> queue = new LinkedList<>();
		int[] dist = new int[2 * v + 2];
		int[] prev = new int[2 * v + 2];
		boolean[] inQ = new boolean[2 * v + 2];
		Edge[] path = new Edge[2 * v + 2];
		int total = 0;

		while (true) {
			for (int i = 0; i <= 2 * v + 1; ++i)
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
				path[i].FlowFunc();
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
			this.rev = null;
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

		public void FlowFunc() {
			++this.flow;
			--this.rev.flow;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = "";
//		String str = null;

		while ((str = br.readLine()) != null) {
//		while (!(str = br.readLine()).equals("")) {
			StringTokenizer st = new StringTokenizer(str);

			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			adj = new ArrayList[2 * v + 2];

			for (int i = 0; i <= 2 * v + 1; ++i)
				adj[i] = new ArrayList<>();

			addEdge(0, 1, 2, 0);
			addEdge(1, v + 1, 2, 0);
			for (int i = 2; i <= v; ++i)
				addEdge(i, v + i, 1, 0);

			for (int i = 0; i < e; ++i) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				addEdge(v + a, b, 1, c);
			}
			addEdge(v, 2 * v, 2, 0);
			addEdge(2 * v, 2 * v + 1, 2, 0);

			bw.write(MCMF(0, 2 * v + 1) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
