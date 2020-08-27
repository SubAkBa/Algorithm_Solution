import java.util.*;

public class Solution_ShortestBridge {
	
//	public void BFS(List<int[]> island, boolean[][] visited, int[][] A, int N, int x, int y) {
//		Queue<int[]> queue = new LinkedList<>();
//
//		queue.offer(new int[] { x, y });
//		visited[x][y] = true;
//		island.add(new int[] { x, y });
//
//		while (!queue.isEmpty()) {
//
//			int[] cur = queue.poll();
//
//			for (int i = 0; i < 4; ++i) {
//				int nx = cur[0] + d[i];
//				int ny = cur[1] + d[i + 1];
//
//				if (!(0 <= nx && nx < N && 0 <= ny && ny < N))
//					continue;
//
//				if (visited[nx][ny])
//					continue;
//
//				if (A[nx][ny] == 0)
//					continue;
//
//				visited[nx][ny] = true;
//				queue.offer(new int[] { nx, ny });
//				island.add(new int[] { nx, ny });
//			}
//		}
//	}

	public static void DFS(List<int[]> island, boolean[][] visited, int[][] A, int N, int x, int y) {
		if (!(0 <= x && x < N && 0 <= y && y < N))
			return;

		if (visited[x][y])
			return;

		if (A[x][y] == 0)
			return;

		visited[x][y] = true;
		island.add(new int[] { x, y });
		DFS(island, visited, A, N, x + 1, y);
		DFS(island, visited, A, N, x - 1, y);
		DFS(island, visited, A, N, x, y + 1);
		DFS(island, visited, A, N, x, y - 1);
	}

	public static int ConstructBridge(List<int[]> island, boolean[][] visited, int[][] A, int N) {
		int len = 0;
		int[] d = { -1, 0, 1, 0, -1 };
		Queue<int[]> queue = new LinkedList<>();

		queue.addAll(island);

		while (!queue.isEmpty()) {
			int size = queue.size();

			while ((--size) >= 0) {
				int[] cur = queue.poll();

				for (int i = 0; i < 4; ++i) {
					int nx = cur[0] + d[i];
					int ny = cur[1] + d[i + 1];

					if (!(0 <= nx && nx < N && 0 <= ny && ny < N))
						continue;

					if (visited[nx][ny])
						continue;

					if (A[nx][ny] == 1)
						return len;

					visited[nx][ny] = true;
					queue.offer(new int[] { nx, ny });
				}
			}

			++len;
		}

		return len;
	}

	public static int shortestBridge(int[][] A) {
		int N = A.length;
		List<int[]> island = new ArrayList<>();
		boolean[][] visited = new boolean[N][N];

		for (int i = 0; i < N * N; ++i) {
			if (A[i / N][i % N] == 1) {
				DFS(island, visited, A, N, i / N, i % N);
				break;
			}
		}

		return ConstructBridge(island, visited, A, N);
	}

	public static void main(String[] args) {
		System.out.println(shortestBridge(new int[][] { { 0, 1 }, { 1, 0 } })); // 1
		System.out.println(shortestBridge(new int[][] { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 0, 1 } })); // 2
		System.out.println(shortestBridge(new int[][] { { 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1 },
				{ 1, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1 } })); // 1
	}
}
