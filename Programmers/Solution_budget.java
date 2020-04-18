
public class Solution_budget {

	public static int Binary_Search(int[] budgets, int M, int max) {
		int left = 0, right = max;
		int answer = 0;

		while (left <= right) {
			int mid = (left + right) / 2;
			int total = 0;

			for (int i = 0; i < budgets.length; i++)
				total += Math.min(mid, budgets[i]);
			
			if(total <= M) {
				answer = mid;
				left = mid + 1;
			} else
				right = mid - 1;
		}
		
		return answer;
	}

	public static int solution(int[] budgets, int M) {
		int max = 0;

		for (int i = 0; i < budgets.length; i++)
			max = Math.max(max, budgets[i]);

		return Binary_Search(budgets, M, max);
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 120, 110, 140, 150 }, 485));
	}

}
