import java.util.*;

public class Solution_예산 {

	public static int solution(int[] d, int budget) {
		int answer = 0;
		Arrays.sort(d);

		for (int D : d) {
			if (budget >= D) {
				budget -= D;
				++answer;
			} else
				break;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 3, 2, 5, 4 }, 9)); // 3
		System.out.println(solution(new int[] { 2, 2, 3, 3 }, 10)); // 4
	}

}
