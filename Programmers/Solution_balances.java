import java.util.*;

public class Solution_balances {

	public static int solution(int[] weight) {
		Arrays.sort(weight);

		int answer = weight[0];

		for (int i = 1; i < weight.length; i++) {
			if (answer + 1 >= weight[i])
				answer += weight[i];
			else
				break;
		}

		return answer + 1;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 3, 1, 6, 2, 7, 30, 1 }));
	}

}
