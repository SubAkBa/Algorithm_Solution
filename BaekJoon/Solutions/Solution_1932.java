import java.io.*;
import java.util.*;

public class Solution_1932 {
	static int[][] triangle, nums;

	public static int Sum(int x, int y) {
		if (x < 1 || y < 1)
			return 0;

		if (triangle[x][y] != 0)
			return triangle[x][y];

		if (x == 1 && y == 1)
			return triangle[x][y] = nums[x][y];

		if (x == y)
			return triangle[x][y] = Sum(x - 1, y - 1) + nums[x][y];
		else if (y == 0)
			return triangle[x][y] = Sum(x - 1, y) + nums[x][y];

		return triangle[x][y] = Math.max(Sum(x - 1, y - 1), Sum(x - 1, y)) + nums[x][y];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine()), max = 0;

		nums = new int[n + 1][n + 1];
		triangle = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 1; j <= i; j++)
				nums[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++)
			Sum(n, i);

		for (int i = 1; i <= n; i++)
			max = Math.max(max, triangle[n][i]);

		bw.write(max + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
