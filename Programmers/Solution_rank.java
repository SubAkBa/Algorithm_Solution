
public class Solution_rank {

	public static void Floyd_Warshall(int n, boolean[][] adj) {
		for (int via = 1; via <= n; ++via) {
			for (int from = 1; from <= n; ++from) {
				for (int to = 1; to <= n; ++to) {
					if (adj[from][via] && adj[via][to])
						adj[from][to] = true;
				}
			}
		}
	}

	public static int solution(int n, int[][] results) {
		int answer = 0;
		boolean[][] adj = new boolean[n + 1][n + 1];

		int rlen = results.length;

		for (int i = 0; i < rlen; ++i)
			adj[results[i][0]][results[i][1]] = true;

		Floyd_Warshall(n, adj);

		for (int i = 1; i <= n; ++i) {
			int temp = 0;

			for (int j = 1; j <= n; ++j)
				temp += (adj[i][j] || adj[j][i] ? 1 : 0);

			if (temp == n - 1)
				++answer;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(5, new int[][] { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } }));
	}
}
