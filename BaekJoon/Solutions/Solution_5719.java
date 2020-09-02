import java.util.*;
import java.io.*;

public class Solution_5719 {
	static int[][] graph;
	static int[] cost;
	static int N, M;
	static LinkedList<Integer>[] list;

	public static int Dijkstra(int start, int end) {
		PriorityQueue<Element> pq = new PriorityQueue<>();

		cost[start] = 0;
		pq.offer(new Element(start, cost[start]));

		while (!pq.isEmpty()) {
			Element cur = pq.poll();

			if (cur.value > cost[cur.idx])
				continue;

			for (int via = 0; via < N; via++) {
				if (graph[cur.idx][via] != Integer.MAX_VALUE) {
					if (cost[via] >= cost[cur.idx] + graph[cur.idx][via]) {
						cost[via] = cost[cur.idx] + graph[cur.idx][via];
						pq.offer(new Element(via, cost[via]));
						list[via].add(cur.idx);
					}
				}
			}
		}
		
		return cost[end] == Integer.MAX_VALUE ? -1 : cost[end];
	}

	public static void DeleteShortestPath(int end) {
		Queue<Integer> queue = new LinkedList<>();

		queue.offer(end);

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			for(Integer pre : list[cur]) {
				if(graph[pre][cur] != Integer.MAX_VALUE && 
						cost[cur] == (cost[pre] + graph[pre][cur])) {
					queue.offer(pre);
					graph[pre][cur] = Integer.MAX_VALUE;
				}
			}
		}
	}

	public static class Element implements Comparable<Element> {
		int idx, value;

		public Element(int idx, int value) {
			this.idx = idx;
			this.value = value;
		}

		public int compareTo(Element n) {
			return this.value - n.value;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			if (N == 0 && M == 0)
				break;

			graph = new int[N][N];
			cost = new int[N];
			list = new LinkedList[N];

			for (int i = 0; i < N; i++) {
				Arrays.fill(graph[i], Integer.MAX_VALUE);
				list[i] = new LinkedList<>();
			}
			Arrays.fill(cost, Integer.MAX_VALUE);

			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());

				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());

				graph[from][to] = cost;
			}

			Dijkstra(start, end);
			DeleteShortestPath(end);
			Arrays.fill(cost, Integer.MAX_VALUE);
			bw.write(Dijkstra(start, end) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
