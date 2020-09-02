import java.util.*;
import java.io.*;

public class Solution_2606_dfs {
	static int[][] graph;
	static boolean[] visited;
	static int V, count = 0;

	public static void Contagion(int start) {
		visited[start] = true;

		for (int via = 1; via <= V; via++) {
			if (graph[start][via] == 1 && !visited[via]) {
				count++;
				Contagion(via);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());

		graph = new int[V + 1][V + 1];
		visited = new boolean[V + 1];

		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			graph[from][to] = graph[to][from] = 1;
		}

		Contagion(1);
		
		bw.write(count + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
