import java.util.*;
import java.io.*;

public class Solution_1068 {
	static int count;

	public static void DFS(int N, List<Integer>[] adj, int R, int node) {
		int temp_count = 0;

		for (int to : adj[node]) {
			if (to == R)
				continue;

			++temp_count;
			DFS(N, adj, R, to);
		}

		if (temp_count == 0)
			++count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		count = 0;

		int[] parent = new int[N];
		List<Integer>[] adj = new ArrayList[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		int root = -1;
		for (int i = 0; i < N; ++i) {
			adj[i] = new ArrayList<>();
			parent[i] = Integer.parseInt(st.nextToken());

			if (parent[i] == -1)
				root = i;
		}

		for (int i = 0; i < N; ++i) {
			if (parent[i] == -1)
				continue;

			adj[parent[i]].add(i);
		}

		int R = Integer.parseInt(br.readLine());

		if (root != R)
			DFS(N, adj, R, root);

		bw.write(count + "");
		bw.flush();
		bw.close();
		br.close();
	}
}