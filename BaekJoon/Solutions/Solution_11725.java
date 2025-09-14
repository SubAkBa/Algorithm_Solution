import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_11725 {
	static int N;
	static int[] parents;
	static boolean[] visited;
	static List<Integer>[] adjList;

	public static void setParents(int node, int prev) {
		parents[node] = prev;
		visited[node] = true;

		for (int next : adjList[node]) {
			if (!visited[next]) {
				setParents(next, node);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		adjList = new ArrayList[N + 1];
		parents = new int[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; ++i) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 1; i < N; ++i) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adjList[a].add(b);
			adjList[b].add(a);
		}

		setParents(1, 1);

		for (int i = 2; i <= N; ++i) {
			System.out.println(parents[i]);
		}
	}
}
