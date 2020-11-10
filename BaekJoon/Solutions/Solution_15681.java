import java.io.*;
import java.util.*;

public class Solution_15681 {

	public static void DFS(int N, List<Integer>[] adj, int[] count, int from, int prev) {
		count[from] = 1;

		for (int to : adj[from]) {
			if (to == prev)
				continue;

			DFS(N, adj, count, to, from);

			count[from] += count[to];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		List<Integer>[] adj = new ArrayList[N + 1];

		for (int i = 0; i <= N; ++i)
			adj[i] = new ArrayList<>();

		for (int i = 1; i < N; ++i) {
			st = new StringTokenizer(br.readLine());

			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());

			adj[U].add(V);
			adj[V].add(U);
		}

		int[] count = new int[N + 1];
		DFS(N, adj, count, R, 0);

		while ((--Q) >= 0)
			bw.write(count[Integer.parseInt(br.readLine())] + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
}
