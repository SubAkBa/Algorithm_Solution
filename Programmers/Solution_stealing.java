
public class Solution_stealing {
	public static int solution(int[] money) {
		int answer = 0, len = money.length;
		int[] total = new int[len];

		if (len == 0)
			return 0;

		if (len == 1)
			return money[0];

		if (len == 2)
			return Math.max(money[0], money[1]);

		total[0] = money[0];
		total[1] = total[0];

		for (int i = 2; i < len - 1; i++) {
			total[i] = Math.max(total[i - 1], total[i - 2] + money[i]);
			answer = Math.max(answer, total[i]);
		}

		total[0] = 0;
		total[1] = money[1];

		for (int i = 2; i < len; i++) {
			total[i] = Math.max(total[i - 1], total[i - 2] + money[i]);
			answer = Math.max(answer, total[i]);
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 2, 3, 1 }));
	}

}
