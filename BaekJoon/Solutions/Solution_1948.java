import java.util.*;
import java.io.*;

public class Solution_1948 {
	static int n, count;
	static int[] indeg, time;
	static ArrayList<Edge>[] edgelist, rev_edgelist;

	public static void Topological_Sort(int start, int end) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);

		while (!queue.isEmpty()) {
			int from = queue.poll();

			for (Edge to : edgelist[from]) {
				time[to.idx] = Math.max(time[to.idx], to.cost + time[from]);

				if ((--indeg[to.idx]) == 0)
					queue.offer(to.idx);

			}
		}

		boolean[] visited = new boolean[n + 1];
		queue.offer(end);

		while (!queue.isEmpty()) {
			int from = queue.poll();

			for (Edge to : rev_edgelist[from]) {
				if (time[to.idx] == time[from] - to.cost) {
					count++;
					
					if (!visited[to.idx]) {
						queue.offer(to.idx);
						visited[to.idx] = true;
					}
				}
			}
		}
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
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		count = 0;
		indeg = new int[n + 1];
		time = new int[n + 1];
		edgelist = new ArrayList[n + 1];
		rev_edgelist = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			edgelist[i] = new ArrayList<>();
			rev_edgelist[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			indeg[b]++;
			edgelist[a].add(new Edge(b, c));
			rev_edgelist[b].add(new Edge(a, c));
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		Topological_Sort(start, end);

		bw.write(time[end] + "\n" + count);
		bw.flush();
		bw.close();
		br.close();
	}

}
