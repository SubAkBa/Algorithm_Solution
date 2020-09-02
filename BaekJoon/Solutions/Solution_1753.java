import java.util.*;
import java.io.*;

public class Solution_1753 {
	static int V, E;
	static ArrayList<Element>[] graph;
	static int[] cost;

	public static void Dijkstra(int start) {
		PriorityQueue<Element> pq = new PriorityQueue<>();

		cost[start] = 0;
		pq.offer(new Element(start, cost[start]));

		while (!pq.isEmpty()) {
			Element from = pq.poll();

			if (from.cost > cost[from.idx])
				continue;

			for (int i = 0; i < graph[from.idx].size(); i++) {
				Element to = graph[from.idx].get(i);
				
				if (cost[to.idx] > cost[from.idx] + to.cost) {
					cost[to.idx] = cost[from.idx] + to.cost;
					pq.offer(new Element(to.idx, cost[to.idx]));
				}
			}
		}
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());

		graph = new ArrayList[V + 1];
		cost = new int[V + 1];

		for (int i = 1; i <= V; i++)
			graph[i] = new ArrayList<>();
		Arrays.fill(cost, Integer.MAX_VALUE);

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph[from].add(new Element(to, cost));
		}

		Dijkstra(start);

		for (int i = 1; i <= V; i++) {
			if (cost[i] == Integer.MAX_VALUE)
				bw.write("INF\n");
			else
				bw.write(cost[i] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
