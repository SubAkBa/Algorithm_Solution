import java.io.*;
import java.util.*;

public class Solution_1932 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine()), max = 0;

		int[][] triangle = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++)
				triangle[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0)
					triangle[i][j] += triangle[i - 1][j];
				else if (i == j)
					triangle[i][j] += triangle[i - 1][j - 1];
				else
					triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);

				if (i == n - 1)
					max = Math.max(triangle[i][j], max);
			}
		}

		bw.write(max + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
