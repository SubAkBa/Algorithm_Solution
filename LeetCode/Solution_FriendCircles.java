
public class Solution_FriendCircles {

	public void DFS(int start, int len, int[][] M, boolean[] visited) {
		visited[start] = true;

		for (int i = 0; i < len; ++i) {
			if (start == i || visited[i] || M[start][i] == 0)
				continue;

			DFS(i, len, M, visited);
		}
	}

	public int findCircleNum(int[][] M) {
		int len = M.length, count = 0;
		boolean[] visited = new boolean[len];

		for (int i = 0; i < len; ++i) {
			if (visited[i])
				continue;

			++count;
			DFS(i, len, M, visited);
		}

		return count;
	}
}
