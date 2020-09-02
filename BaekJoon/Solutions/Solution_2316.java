import java.util.*;
import java.io.*;

public class Solution_2316 {
	static int N, P;
	static ArrayList<Edge>[] adj;

	public static class Edge {
		int idx, capacity, flow;
		Edge rev;

		public Edge() {
			this.idx = -1;
			this.capacity = 0;
			this.flow = 0;
			this.rev = null;
		}

		public Edge(int idx, int capacity) {
			this.idx = idx;
			this.capacity = capacity;
			this.flow = 0;
			this.rev = null;
		}

		public boolean isRemain() {
			if (this.capacity - this.flow > 0)
				return true;

			return false;
		}

		public void Flowing() {
			++this.flow;
			--this.rev.flow;
		}
	}

	public static int Network_Flow(int source, int sink) {
		int count = 0;
		Queue<Integer> queue = new LinkedList<>();
		int[] prev = new int[2 * N + 1];
		Edge[] path = new Edge[2 * N + 1];

		while (true) {
			queue.offer(source);
			Arrays.fill(prev, -1);

			for (int i = 1; i <= 2 * N; ++i)
				path[i] = new Edge();

			while (!queue.isEmpty()) {
				int from = queue.poll();

				for (Edge to : adj[from]) {
					if (to.isRemain() && prev[to.idx] == -1) {
						prev[to.idx] = from;
						path[to.idx] = to;
						queue.offer(to.idx);
					}
				}
			}

			if (prev[sink] == -1)
				break;

			for (int i = sink; i != source; i = prev[i])
				path[i].Flowing();

			++count;
		}

		return count;
	}

	public static void addEdge(int from, int to, int capacity) {
		Edge e1 = new Edge(to, capacity);
		Edge e2 = new Edge(from, 0);

		e1.rev = e2;
		e2.rev = e1;

		adj[from].add(e1);
		adj[to].add(e2);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		adj = new ArrayList[2 * N + 1];

		for (int i = 1; i <= 2 * N; ++i)
			adj[i] = new ArrayList<>();

		for (int i = 3; i <= N; ++i) {
			addEdge(i, i + N, 1);
			addEdge(i + N, i, 1);
		}

		addEdge(1, N + 1, 1);
		for (int i = 0; i < P; ++i) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			addEdge(from + N, to, 1);
			addEdge(to + N, from, 1);
		}

		bw.write(Network_Flow(1 + N, 2) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
