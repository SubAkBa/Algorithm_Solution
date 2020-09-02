import java.util.*;
import java.io.*;

public class Solution_10282 {
	static int V, E, computer, INF = 987654321;
	static int[] dist;
	static ArrayList<Edge>[] edge;

	public static void HackingComputer(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		dist[start] = 0;
		pq.offer(new Edge(start, dist[start]));

		while (!pq.isEmpty()) {
			Edge from = pq.poll();

			if (from.cost > dist[from.idx])
				continue;

			for (Edge to : edge[from.idx]) {
				if (dist[to.idx] > dist[from.idx] + to.cost) {
					if(dist[to.idx] == INF)						// INF라면 처음 해킹당하는 컴퓨터이므로
						computer++;								// 컴퓨터 갯수를 늘려준다.
					dist[to.idx] = dist[from.idx] + to.cost;
					pq.offer(new Edge(to.idx, dist[to.idx]));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int testcase = Integer.parseInt(br.readLine());

		for (int i = 0; i < testcase; i++) {
			st = new StringTokenizer(br.readLine());

			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			edge = new ArrayList[V + 1];
			dist = new int[V + 1];
			Arrays.fill(dist, INF);

			computer = 1;					// 해킹이 시작되는 컴퓨터 갯수까지 포함하기 위해

			for (int j = 1; j <= V; j++)
				edge[j] = new ArrayList<>();

			for (int j = 0; j < E; j++) {
				st = new StringTokenizer(br.readLine());

				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());

				edge[to].add(new Edge(from, cost));		// 방향 그래프 (b -> a) 이므로
			}

			HackingComputer(start);
											// INF (연결되지않은) 값을 제외하고
											// 가장 큰 값을 찾기 위한 제거와 정렬과정
			int[] result = Arrays.stream(dist).filter(k -> k != INF).toArray(); 
			Arrays.sort(result);												

			bw.write(computer + " " + result[result.length - 1]);
			bw.newLine();

		}

		bw.flush();
		bw.close();
		br.close();
	}

	public static class Edge implements Comparable<Edge> {
		int idx, cost;

		public Edge(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}

		public int compareTo(Edge e) {
			return this.cost - e.cost;
		}
	}
}
