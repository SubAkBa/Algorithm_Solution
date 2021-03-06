import java.util.*;
import java.io.*;

public class Solution_2211 {
	static int[][] graph;
	static int N, INF = 987654321;

	public static int[] NetworkRestore(int start) {
		PriorityQueue<Element> pq = new PriorityQueue<>();
		int[] pathlist = new int[N + 1], cost = new int[N + 1];

		Arrays.fill(cost, INF);
		Arrays.fill(pathlist, -1);
		
		cost[start] = 0;
		pq.offer(new Element(start, cost[start]));

		while (!pq.isEmpty()) {
			Element from = pq.poll();

			if (from.cost > cost[from.idx])
				continue;

			for (int to = 1; to <= N; to++) {
				if (cost[to] > cost[from.idx] + graph[from.idx][to]) {
					cost[to] = cost[from.idx] + graph[from.idx][to];
					pq.offer(new Element(to, cost[to]));
					pathlist[to] = from.idx;
				}
			}
		}
		
		return pathlist;
	}

	public static class Element implements Comparable<Element> {
		int idx, cost;

		public Element(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}

		public int compareTo(Element e) {
			return this.cost - e.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int count = 0;

		graph = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++)
				graph[i][j] = (i == j) ? 0 : INF;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph[from][to] = graph[to][from] = cost;
		}

		int[] pathlist = NetworkRestore(1);

		for (int i = 1; i <= N; i++) {
			if (pathlist[i] == -1)
				continue;
			
			count++;
			sb.append(i + " " + pathlist[i] + "\n");
		}
		
		bw.write(count + "\n" + sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}
}
