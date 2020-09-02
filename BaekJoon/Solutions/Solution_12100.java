import java.util.*;
import java.io.*;

public class Solution_12100 {
	static int N, answer = 0;

	public static int GetMax(int[][] board) {
		int max = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				max = Math.max(max, board[i][j]);
		}

		return max;
	}

	public static void Move(int[][] board, int dir) {
		Queue<Integer> queue = new LinkedList<>();

		switch (dir) {
		case 0:
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[j][i] != 0) {
						queue.offer(board[j][i]);
						board[j][i] = 0;
					}
				}

				int idx = 0;
				while (!queue.isEmpty()) {
					int prev = queue.poll();

					if (queue.isEmpty())
						board[idx++][i] = prev;
					else {
						if (prev == queue.peek())
							board[idx++][i] = prev + queue.poll();
						else
							board[idx++][i] = prev;
					}
				}
			}
			break;
		case 1:
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j >= 0; j--) {
					if (board[i][j] != 0) {
						queue.offer(board[i][j]);
						board[i][j] = 0;
					}
				}

				int idx = N - 1;
				while (!queue.isEmpty()) {
					int prev = queue.poll();

					if (queue.isEmpty())
						board[i][idx--] = prev;
					else {
						if (prev == queue.peek())
							board[i][idx--] = prev + queue.poll();
						else
							board[i][idx--] = prev;
					}
				}
			}
			break;
		case 2:
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j >= 0; j--) {
					if (board[j][i] != 0) {
						queue.offer(board[j][i]);
						board[j][i] = 0;
					}
				}

				int idx = N - 1;
				while (!queue.isEmpty()) {
					int prev = queue.poll();

					if (queue.isEmpty())
						board[idx--][i] = prev;
					else {
						if (prev == queue.peek())
							board[idx--][i] = prev + queue.poll();
						else
							board[idx--][i] = prev;
					}
				}
			}
			break;
		case 3:
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] != 0) {
						queue.offer(board[i][j]);
						board[i][j] = 0;
					}
				}

				int idx = 0;
				while (!queue.isEmpty()) {
					int prev = queue.poll();

					if (queue.isEmpty())
						board[i][idx++] = prev;
					else {
						if (prev == queue.peek())
							board[i][idx++] = prev + queue.poll();
						else
							board[i][idx++] = prev;
					}
				}
			}
			break;
		}
	}

	public static int[][] CopyBoard(int[][] board) {
		int[][] cpboard = new int[N][N];

		for (int i = 0; i < N; i++)
			System.arraycopy(board[i], 0, cpboard[i], 0, N);

		return cpboard;
	}

	public static void Game2048(int[][] board, int turn) {
		if (turn == 5) {
			answer = Math.max(answer, GetMax(board));

			return;
		}

		for (int i = 0; i < 4; i++) {
			int[][] cpboard = CopyBoard(board);
			Move(cpboard, i);
			Game2048(cpboard, turn + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());

		int[][] board = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}

		Game2048(board, 0);

		bw.write(answer + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
