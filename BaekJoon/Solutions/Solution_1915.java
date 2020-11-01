import java.util.*;
import java.io.*;

public class Solution_1915 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n + 1][m + 1];
		for (int i = 1; i <= n; ++i) {
			String str = br.readLine();

			for (int j = 1; j <= m; ++j)
				map[i][j] = str.charAt(j - 1) - '0';
		}

		int max_width = 0;
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= m; ++j) {
				if (map[i][j] == 0)
					continue;

				map[i][j] = Math.min(Math.min(map[i - 1][j], map[i][j - 1]), map[i - 1][j - 1]) + 1;

				if (max_width < map[i][j])
					max_width = map[i][j];
			}
		}

		bw.write((max_width * max_width) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
