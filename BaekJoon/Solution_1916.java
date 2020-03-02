import java.util.*;
import java.io.*;

public class dijkstra_1916_solution {
	static int[][] map;
	static boolean[] visited;
	static long[] cost;
	static int city;
	
	public static void Dijkstra(int start, int end) {
		cost[start] = 0;

		for (int i = 1; i <= city; i++) {
			long min = Integer.MAX_VALUE;
			int from = -1;

			for (int j = 1; j <= city; j++) {
				if (!visited[j] && min > cost[j]) {
					from = j;
					min = cost[j];
				}
			}

			visited[from] = true;

			for (int to = 1; to <= city; to++) {
				if (map[from][to] != -1 && cost[from] != Integer.MAX_VALUE - 1 && cost[to] > cost[from] + map[from][to])
					cost[to] = cost[from] + map[from][to];
			}
		}

		System.out.println(cost[end]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		city = Integer.parseInt(br.readLine());

		map = new int[city + 1][city + 1];
		visited = new boolean[city + 1];
		cost = new long[city + 1];

		for (int i = 1; i <= city; i++)
			Arrays.fill(map[i], -1);

		Arrays.fill(visited, false);
		Arrays.fill(cost, Integer.MAX_VALUE - 1);

		int road = Integer.parseInt(br.readLine());

		for (int i = 0; i < road; i++) {
			String[] infos = br.readLine().split(" ");

			int from = Integer.parseInt(infos[0]);
			int to = Integer.parseInt(infos[1]);
			int cost = Integer.parseInt(infos[2]);

			if (map[from][to] == -1) {
				map[from][to] = cost;
			} else if (map[from][to] > cost)
				map[from][to] = cost;

		}

		String[] question = br.readLine().split(" ");
		int start = Integer.parseInt(question[0]);
		int end = Integer.parseInt(question[1]);
		
		Dijkstra(start, end);
	}

}
