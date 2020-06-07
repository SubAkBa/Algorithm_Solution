import java.util.*;

public class Solution_fromseoultogyeongsan {

	public static int solution(int K, int[][] travel) {
		int answer = 0, len = travel.length;
		int[][] cost = new int[len + 1][K + 1];

		cost[0][travel[0][0]] = travel[0][1];
		cost[0][travel[0][2]] = travel[0][3];

		for (int i = 1; i < len; i++) {
			for (int k = 0; k <= K; k++) {
				if(cost[i - 1][k] == 0)
					continue;
				
				if (k + travel[i][0] <= K) {
					cost[i][k + travel[i][0]] = Math.max(cost[i][k + travel[i][0]], cost[i - 1][k] + travel[i][1]);
					answer = Math.max(answer, cost[i][k + travel[i][0]]);
				}

				if (k + travel[i][2] <= K) {
					cost[i][k + travel[i][2]] = Math.max(cost[i][k + travel[i][2]], cost[i - 1][k] + travel[i][3]);
					answer = Math.max(answer, cost[i][k + travel[i][2]]);
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(
				solution(1650, new int[][] { { 500, 200, 200, 100 }, { 800, 370, 300, 120 }, { 700, 250, 300, 90 } }));
		System.out.println(solution(3000, new int[][] { { 1000, 2000, 300, 700 }, { 1100, 1900, 400, 900 },
				{ 900, 1800, 400, 700 }, { 1200, 2300, 500, 1200 } }));
	}

}
