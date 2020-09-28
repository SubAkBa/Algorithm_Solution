import java.util.*;
import java.io.*;

public class Solution_2458 {

	public static void Floyd_Warshall(int[][] adj, int N) {
		for (int via = 1; via <= N; ++via) {
			for (int from = 1; from <= N; ++from) {
				for (int to = 1; to <= N; ++to) {
					if (adj[from][via] == 1 && adj[via][to] == 1)
						adj[from][to] = 1;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] adj = new int[N + 1][N + 1];

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adj[a][b] = 1;
		}

		Floyd_Warshall(adj, N);

		int total = 0;
		for (int i = 1; i <= N; ++i) {
			int count = 0;

			for (int j = 1; j <= N; ++j) {
				if (adj[i][j] == 1 || adj[j][i] == 1)
					++count;
			}

			if (count == N - 1)
				++total;
		}

		bw.write(total + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
