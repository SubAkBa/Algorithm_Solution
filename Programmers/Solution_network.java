import java.util.*;

public class Solution_network {
	static boolean[] visited;
	static int[][] graph;
	static int N, count;

	public static void DFS(int num) {
		visited[num] = true;

		for (int i = 1; i <= N; i++) {
			if (num == i)
				continue;

			if (graph[num][i] == 1 && !visited[i])
				DFS(i);
		}
	}

	public static int solution(int n, int[][] computers) {
		count = 0;
		N = n;
		visited = new boolean[n + 1];
		graph = new int[n + 1][n + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++)
				graph[i][j] = computers[i - 1][j - 1];
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				DFS(i);
				count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		System.out.println(solution(3, new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } }));
		System.out.println(solution(3, new int[][] { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } }));
	}

}
