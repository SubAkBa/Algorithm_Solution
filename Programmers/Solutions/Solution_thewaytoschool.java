import java.util.*;

public class Solution_thewaytoschool {

	public static int solution(int m, int n, int[][] puddles) {
		int[][] map = new int[n + 1][m + 1];
		
		for (int[] puddle : puddles)
			map[puddle[1]][puddle[0]] = -1;

		map[1][1] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				
				if(map[i][j] == -1) {
					map[i][j] = 0;
					continue;
				}
				
				if(i != 1)
					map[i][j] += map[i -1][j] % 1000000007;
				
				if(j != 1)
					map[i][j] += map[i][j - 1] % 1000000007;
			}
		}

		return map[n][m] % 1000000007;
	}

	public static void main(String[] args) {
		System.out.println(solution(4, 3, new int[][] { { 2, 2 } }));
	}

}
