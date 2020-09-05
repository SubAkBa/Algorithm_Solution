import java.util.*;

public class Solution_경주로건설 {

	public static int Constructing(int N, int[][] cost, int[][] board) {
		int[] d = { -1, 0, 1, 0, -1 };
		Queue<int[]> queue = new LinkedList<>();

		cost[0][0] = 0;
		queue.offer(new int[] { 0, 0, cost[0][0], 1 });
		queue.offer(new int[] { 0, 0, cost[0][0], 2 });

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			for (int i = 0; i < 4; ++i) {
				int nx = current[0] + d[i];
				int ny = current[1] + d[i + 1];
				int ncost = current[2];
				int ndir = current[3];

				if (!(0 <= nx && nx < N && 0 <= ny && ny < N))
					continue;

				if (board[nx][ny] == 1)
					continue;

				if (ndir != i)
					ncost += 500;

				if (cost[nx][ny] < ncost + 100)
					continue;

				cost[nx][ny] = ncost + 100;
				queue.offer(new int[] { nx, ny, cost[nx][ny], i });
			}
		}

		return cost[N - 1][N - 1];
	}

	public static int solution(int[][] board) {
		int N = board.length, INF = 987654321;
		int[][] cost = new int[N][N];

		for (int i = 0; i < N; ++i)
			Arrays.fill(cost[i], INF);

		return Constructing(N, cost, board);
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } })); // 900
		System.out.println(solution(new int[][] { { 0, 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0, 1 },
				{ 0, 0, 1, 0, 0, 0, 1, 0 }, { 0, 1, 0, 0, 0, 1, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0 } })); // 3800
		System.out.println(solution(new int[][] { { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 1 }, { 1, 0, 0, 0 } })); // 2100
		System.out.println(solution(new int[][] { { 0, 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 1, 0 }, { 0, 0, 1, 0, 0, 0 },
				{ 1, 0, 0, 1, 0, 1 }, { 0, 1, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0 } })); // 3200
	}
}
