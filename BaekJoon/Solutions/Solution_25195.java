import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_25195 {
	static List<Integer>[] adjList;
	static boolean[] exist;
	static boolean result;
	static int N, M;

	public static void dfs(int node) {
		if (result) {
			return;
		}

		if (exist[node]) {
			return;
		}

		if (adjList[node].size() == 0) {
			result = true;
			return;
		}

		for (int next : adjList[node]) {
			dfs(next);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[N + 1];
		exist = new boolean[N + 1];
		result = false;

		for (int i = 1; i <= N; ++i) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			adjList[u].add(v);
		}

		int S = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < S; ++i) {
			int node = Integer.parseInt(st.nextToken());

			exist[node] = true;
		}

		dfs(1);

		System.out.println(result ? "yes" : "Yes");
	}
}
