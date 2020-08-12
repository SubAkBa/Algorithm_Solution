import java.util.*;
import java.io.*;

public class Solution_Ladder1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = 10;

		while ((--T) >= 0) {
			final int size = 100;
			int tnum = Integer.parseInt(br.readLine());

			int[][] map = new int[size][size];
			int[] start = null;

			for (int i = size - 1; i >= 0; --i) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for (int j = 0; j < size; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());

					if (map[i][j] == 2)
						start = new int[] { i, j };
				}
			}

			int[] dy = { -1, 1 };
			while (start[0] < size) {
				boolean isDown = true;

				for (int i = 0; i < 2; ++i) {
					int ny = start[1] + dy[i];

					if (!(0 <= ny && ny < size))
						continue;

					if (map[start[0]][ny] == 0)
						continue;

					map[start[0]][start[1]] = 0;
					start[1] = ny;
					isDown = false;
				}

				if (isDown)
					++start[0];
			}

			bw.write("#" + tnum + " " + start[1] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
