import java.util.*;
import java.io.*;

public class Solution_11657 {
	static int[] cost;
	static ArrayList<Edge>[] edgelist;
	static boolean[] isinQ;
	static int N, INF = 987654321;

	public static boolean TimeMachine(int start) {
		Queue<Edge> queue = new LinkedList<>();
		int[] cycle = new int[N + 1];

		cost[start] = 0;
		isinQ[start] = true;
		cycle[start]++;
		queue.offer(new Edge(start, cost[start]));

		while (!queue.isEmpty()) {
			Edge from = queue.poll();
			isinQ[from.idx] = false;

			for (Edge to : edgelist[from.idx]) {
				if (cost[to.idx] > cost[from.idx] + to.cost) {
					cost[to.idx] = cost[from.idx] + to.cost;

					if (!isinQ[to.idx]) {
						cycle[to.idx]++;

						if (cycle[to.idx] >= N)
							return false;

						queue.offer(new Edge(to.idx, cost[to.idx]));
						isinQ[to.idx] = true;
					}
				}
			}
		}
		return true;
	}

	public static class Edge {
		int idx, cost;

		public Edge(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		isinQ = new boolean[N + 1];
		cost = new int[N + 1];
		edgelist = new ArrayList[N + 1];

		Arrays.fill(cost, INF);

		for (int i = 1; i <= N; i++)
			edgelist[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			edgelist[from].add(new Edge(to, cost));
		}

		if (TimeMachine(1)) {
			for (int i = 2; i <= N; i++) {
				if (cost[i] == INF)
					bw.write("-1\n");
				else
					bw.write(cost[i] + "\n");
			}
		} else {
			bw.write("-1");
		}

		bw.flush();
		bw.close();
		br.close();

	}
}
