import java.io.*;

public class Solution_1992 {
	static StringBuilder sb;
	static int[][] map;

	public static void Compress(int N, int y, int x) {
		if (N == 1) {
			sb.append(map[y][x]);
			return;
		}

		boolean zero = true, one = true;

		for (int i = y; i < y + N; i++) {
			for (int j = x; j < x + N; j++) {
				if (map[i][j] == 1)
					zero = false;
				else
					one = false;
			}
		}

		if (zero)
			sb.append(0);
		else if (one)
			sb.append(1);
		else {
			sb.append("(");
			Compress(N / 2, y, x);
			Compress(N / 2, y, x + N / 2);
			Compress(N / 2, y + N / 2, x);
			Compress(N / 2, y + N / 2, x + N / 2);
			sb.append(")");
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			String s = br.readLine();

			for (int j = 0; j < N; j++)
				map[i][j] = s.charAt(j) - '0';
		}

		Compress(N, 0, 0);
		bw.write(sb.toString() + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
