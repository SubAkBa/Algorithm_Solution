import java.util.*;
import java.io.*;

public class Solution_1149 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] cost = new int[N][3];
		int[][] sum = new int[N][3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());

				if (i == 0)
					sum[i][j] = cost[i][j];
			}
		}

		for (int i = 1; i < N; i++) {
			sum[i][0] = Math.min(sum[i - 1][1], sum[i - 1][2]) + cost[i][0];
			sum[i][1] = Math.min(sum[i - 1][0], sum[i - 1][2]) + cost[i][1];
			sum[i][2] = Math.min(sum[i - 1][0], sum[i - 1][1]) + cost[i][2];
		}

		int min = Math.min(Math.min(sum[N - 1][0], sum[N - 1][1]), sum[N - 1][2]);

		bw.write(min + " ");
		bw.flush();
		bw.close();
		br.close();
	}
}
