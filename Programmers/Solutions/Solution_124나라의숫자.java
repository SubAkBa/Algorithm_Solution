
public class Solution_124countrynumber {

	public static String solution(int n) {
		StringBuilder sb = new StringBuilder();

		while (n > 0) {
			int rest = n % 3;
			n /= 3;

			if (rest == 0) {
				rest = 4;
				n--;
			}
			sb.insert(0, rest);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(solution(1));
		System.out.println(solution(2));
		System.out.println(solution(3));
		System.out.println(solution(4));
		System.out.println(solution(15));
	}

}
