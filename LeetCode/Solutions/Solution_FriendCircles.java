
public class Solution_FriendCircles {
	
	static int count = 0;

	public static void DFS(int N, int current, int[][] M, boolean[] visited) {
		visited[current] = true;

		for (int next = 0; next < N; ++next) {
			if (M[current][next] == 0 || visited[next])
				continue;

			DFS(N, next, M, visited);
		}
	}

	public static int findCircleNum(int[][] M) {
		int N = M.length;
		boolean[] visited = new boolean[N];

		for (int i = 0; i < N; ++i) {
			if (visited[i])
				continue;

			++count;
			DFS(N, i, M, visited);
		}

		return count;
	}

	public static void main(String[] args) {
		System.out.println(findCircleNum(new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } }));
		System.out.println(findCircleNum(new int[][] { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } }));
	}
}
