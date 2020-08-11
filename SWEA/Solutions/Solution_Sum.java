import java.util.*;
import java.io.*;

public class Solution_Sum {
	static int len = 100;

	public static int Sum(int[][] map) {
		int max = 0;
		int[] colsum = new int[len], diagsum = new int[2];

		for (int i = 0; i < len; i++) {
			int rowsum = 0; 
			
			for (int j = 0; j < len; j++) {
				rowsum += map[i][j];
				colsum[j] += map[i][j];

				if (i == j)
					diagsum[0] += map[i][j];

				if ((i + j + 1) == len)
					diagsum[1] += map[i][j];
			}

			max = Math.max(max, rowsum);

			if (i == (len - 1)) {
				for (int j = 0; j < len; j++)
					max = Math.max(max, colsum[j]);

				max = Math.max(max, Math.max(diagsum[0], diagsum[1]));
			}
		}

		return max;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = 10;

		while ((T--) > 0) {
			int casenum = Integer.parseInt(br.readLine());
			int[][] map = new int[len][len];

			for (int i = 0; i < len; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < len; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}

			bw.write("#" + casenum + " " + Sum(map) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
