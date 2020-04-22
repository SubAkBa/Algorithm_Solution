
public class Solution_expectedmatchtable {
	public static int solution(int n, int a, int b) {
		int answer = 0;

		while (a != b) {
			a = a / 2 + a % 2;
			b = b / 2 + b % 2;

			answer++;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(8, 4, 7));
	}

}
