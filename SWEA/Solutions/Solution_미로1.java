import java.util.*;
import java.io.*;

public class Solution_미로1 {

	public static int BFS(int[][] map, int[] start, int size) {
		int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, 1, -1 };
		Queue<int[]> queue = new LinkedList<>();

		map[start[0]][start[1]] = 1;
		queue.offer(start);

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			for (int i = 0; i < 4; ++i) {
				int nx = current[0] + dx[i];
				int ny = current[1] + dy[i];

				if (!(1 <= nx && nx < size - 2 && 1 <= ny && ny < size - 2))
					continue;

				if (map[nx][ny] == 1)
					continue;

				if (map[nx][ny] == 3)
					return 1;

				map[nx][ny] = 1;
				queue.offer(new int[] { nx, ny });
			}
		}

		return 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = 10, size = 16;

		while ((--T) >= 0) {
			int tnum = Integer.parseInt(br.readLine());
			int[][] map = new int[size][size];

			int[] start = null;

			for (int i = 0; i < size; ++i) {
				char[] ch = br.readLine().toCharArray();

				for (int j = 0; j < size; ++j) {
					map[i][j] = ch[j] - '0';

					if (map[i][j] == 2)
						start = new int[] { i, j };
				}
			}

			bw.write("#" + tnum + " " + BFS(map, start, size) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
