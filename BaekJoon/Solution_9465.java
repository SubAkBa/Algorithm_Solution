import java.util.*;
import java.io.*;

public class Solution_9465 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		while ((T--) > 0) {
			int n = Integer.parseInt(br.readLine());
			int[][] sticker = new int[2][n], score = new int[2][n];

			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++)
					score[i][j] = sticker[i][j] = Integer.parseInt(st.nextToken());
			}

			score[0][1] += score[1][0];
			score[1][1] += score[0][0];

			for (int i = 2; i < n; i++) {
				score[0][i] += Math.max(score[1][i - 1], score[1][i - 2]);
				score[1][i] += Math.max(score[0][i - 1], score[0][i - 2]);
			}

			bw.write(Math.max(score[0][n - 1], score[1][n - 1]) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
