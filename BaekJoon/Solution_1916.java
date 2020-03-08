import java.util.*;
import java.io.*;

public class Solution_1916 {
	static int[][] graph;
	static int[] cost;
	static int N, M;

	public static int BusPath(int start, int end) {
		PriorityQueue<Element> pq = new PriorityQueue<>();

		cost[start] = 0;
		pq.offer(new Element(start, cost[start]));

		while (!pq.isEmpty()) {
			Element from = pq.poll();

			if (from.cost > cost[from.idx])
				continue;

			for (int to = 1; to <= N; to++) {
				if (graph[from.idx][to] != Integer.MAX_VALUE) {
					if (cost[to] > cost[from.idx] + graph[from.idx][to]) {
						cost[to] = cost[from.idx] + graph[from.idx][to];
						pq.offer(new Element(to, cost[to]));
					}
				}
			}
		}

		return cost[end];
	}

	public static class Element implements Comparable<Element> {
		int idx, cost;

		public Element(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}

		@Override
		public int compareTo(Element e) {
			return this.cost - e.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new int[N + 1][N + 1];
		cost = new int[N + 1];

		for (int i = 1; i <= N; i++)
			Arrays.fill(graph[i], Integer.MAX_VALUE);
		Arrays.fill(cost, Integer.MAX_VALUE);

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			if (graph[from][to] == Integer.MAX_VALUE)
				graph[from][to] = cost;
			else if (graph[from][to] != Integer.MAX_VALUE && graph[from][to] > cost)
				graph[from][to] = cost;
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		bw.write(BusPath(start, end) + " ");
		bw.flush();
		bw.close();
		br.close();
	}
}
