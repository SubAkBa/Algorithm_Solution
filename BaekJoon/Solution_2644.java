import java.util.*;
import java.io.*;

public class Solution_2644 {
	static int[][] graph;
	static boolean[] visited;
	static int[] depth;
	static int n;

	public static int DegreeOfKinship(int x, int y) { // 촌수 계산 x = 부모, y = 자식
		Queue<Integer> queue = new LinkedList<>();
		int answer = 1;

		visited[x] = true;
		queue.add(x);

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			for (int i = 1; i <= n; i++) {				// 두 사람이 1촌으로 연결되어 있고
				if(graph[cur][i] == 1 && !visited[i]) { // 아직 방문하지 않았다면
					depth[i] = depth[cur] + 1;			// 다음 (i) 촌수는 현재 (cur) 촌수 + 1을 해준다.
					visited[i] = true;
					queue.add(i);
				}
			}
		}
		
		return depth[y] == 0 ? -1 : depth[y];			// depth[y] == 0이라는 것은 연결되어 있지 않다는 것이므
	}													// -1을 출력하고 이외의 경우면 연결되어 있으므로 그대로 출

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());

		graph = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		depth = new int[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			graph[from][to] = graph[to][from] = 1;
		}

		bw.write(DegreeOfKinship(x, y) + " ");
		
		bw.flush();
		bw.close();
		br.close();
	}

}
