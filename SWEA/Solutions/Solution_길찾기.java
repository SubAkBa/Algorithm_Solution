import java.util.*;
import java.io.*;

public class Solution_길찾기 {
	static int answer;

	public static void DFS(List<Integer>[] adj, int start) {
		if (answer == 1)
			return;

		for (int to : adj[start]) {
			if (to == 99)
				answer = 1;

			DFS(adj, to);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = 100, T = 10;

		while ((--T) >= 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			answer = 0;
			int tnum = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			List<Integer>[] adj = new ArrayList[size];

			for (int i = 0; i < size; ++i)
				adj[i] = new ArrayList<>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; ++i) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				adj[from].add(to);
			}
			DFS(adj, 0);

			bw.write("#" + tnum + " " + answer + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
