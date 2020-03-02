import java.util.*;
import java.io.*;

public class dijkstra_1238_solution {
	static int vertex, party;
	static int[] fordist, revdist;
	static LinkedList<Graph>[] forward, reverse;
	static final int INF = 987654321;

	public static void Dijkstra(LinkedList<Graph>[] list, int[] dist, int start) {
		PriorityQueue<Graph> pq = new PriorityQueue<>();

		pq.offer(new Graph(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Graph from = pq.poll();
			
			if (from.dist > dist[from.idx])
				continue;

			for (int i = 0; i < list[from.idx].size(); i++) {
				Graph to = list[from.idx].get(i);
				
				if (dist[to.idx] > dist[from.idx] + to.dist) {
					dist[to.idx] = dist[from.idx] + to.dist;
					pq.offer(new Graph(to.idx, dist[to.idx]));
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		vertex = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		party = Integer.parseInt(st.nextToken());

		forward = new LinkedList[vertex + 1];
		reverse = new LinkedList[vertex + 1];

		fordist = new int[vertex + 1];
		revdist = new int[vertex + 1];

		for (int i = 1; i <= vertex; i++) {
			forward[i] = new LinkedList<>();
			reverse[i] = new LinkedList<>();
		}

		Arrays.fill(fordist, INF);
		Arrays.fill(revdist, INF);

		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			forward[from].add(new Graph(to, cost));
			reverse[to].add(new Graph(from, cost));
		}

		Dijkstra(forward, fordist, party);
		Dijkstra(reverse, revdist, party);

		int max = 0;

		for (int i = 1; i <= vertex; i++) {
			max = Math.max(max, fordist[i] + revdist[i]);
		}

		bw.write(max + " ");

		bw.flush();
		bw.close();
		br.close();
	}

}

class Graph implements Comparable<Graph> {
	int idx, dist;

	public Graph(int idx, int dist) {
		this.idx = idx;
		this.dist = dist;
	}

	@Override
	public int compareTo(Graph g) {
		return dist < g.dist ? -1 : 1;
	}
}