import java.util.*;
import java.io.*;

public class Solution_2098 {
	static int INF = 987654321;

	public static int TSP(int[][] dp, int N, int[][] cost, int current, int visited) {
//		if (visited == ((1 << (N + 1)) - (1 << 1)))
		if (visited == ((1 << N) - 1))
//			return cost[current][1] == 0 ? INF : cost[current][1];
			return cost[current][0] == 0 ? INF : cost[current][0];

		if (dp[current][visited] != 0)
			return dp[current][visited];

		int min_cost = INF;
		for (int i = 0; i < N; ++i) {
			if ((visited & (1 << i)) != 0 || cost[current][i] == 0)
				continue;

			min_cost = Math.min(min_cost, TSP(dp, N, cost, i, (visited | (1 << i))) + cost[current][i]);
		}

		return dp[current][visited] = min_cost;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
//		int[][] cost = new int[N + 1][N + 1];
//		int[][] dp = new int[N + 1][1 << (N + 1)];

		int[][] cost = new int[N][N];
		int[][] dp = new int[N][1 << N];

		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; ++j)
				cost[i][j] = Integer.parseInt(st.nextToken());
		}

//		bw.write(TSP(dp, N, cost, 1, 2) + "");
		bw.write(TSP(dp, N, cost, 0, 1) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}