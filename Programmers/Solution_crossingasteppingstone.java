
public class Solution_crossingasteppingstone {

	public static int solution(int[] stones, int k) {
		int answer = 0, len = stones.length;
		int min = 1, max = 0;

		for (int i = 0; i < len; i++)
			max = Math.max(max, stones[i]);

		while (min <= max) {
			boolean check = false;
			int mid = (min + max) / 2;
			int zero_stone = 0;

			for (int i = 0; i < len; i++) {
				if (stones[i] >= mid)
					zero_stone = 0;
				else
					zero_stone++;

				if (zero_stone >= k) {
					check = true;
					break;
				}
			}

			if (check)
				max = mid - 1;
			else {
				answer = Math.max(answer, mid);
				min = mid + 1;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 }, 3));
	}

}
