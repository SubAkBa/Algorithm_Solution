import java.util.*;
import java.io.*;

public class Solution_1504 {
	static int[][] graph;
	static int N;

	public static int[] SpecialPath(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] cost = new int[N + 1];

		Arrays.fill(cost, Integer.MAX_VALUE);

		cost[start] = 0;
		pq.offer(new Node(start, cost[start]));

		while (!pq.isEmpty()) {
			Node from = pq.poll();

			if (from.cost > cost[from.idx])
				continue;

			for (int to = 1; to <= N; to++) {
				if (graph[from.idx][to] != Integer.MAX_VALUE && cost[to] > cost[from.idx] + graph[from.idx][to]) {
					cost[to] = cost[from.idx] + graph[from.idx][to];
					pq.offer(new Node(to, cost[to]));
				}
			}
		}

		return cost;
	}

	public static class Node implements Comparable<Node> {
		int idx, cost;

		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}

		public int compareTo(Node n) {
			return this.cost - n.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		graph = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++)
				graph[i][j] = (i == j) ? 0 : Integer.MAX_VALUE;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph[from][to] = graph[to][from] = cost;
		}

		st = new StringTokenizer(br.readLine());

		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());

		int[] costn1 = SpecialPath(n1);
		int[] costn2 = SpecialPath(n2);

		int result = costn1[n2] + Math.min(costn1[1] + costn2[N], costn1[N] + costn2[1]);
		if (result < 0 || result >= Integer.MAX_VALUE - 2)
			result = -1;

		bw.write(result + " ");
		bw.flush();
		bw.close();
		br.close();
	}
}