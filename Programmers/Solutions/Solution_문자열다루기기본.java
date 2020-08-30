
public class Solution_stringprocessbasic {

	public static boolean solution(String s) {
		int len = s.length();

		if (len != 4 && len != 6)
			return false;

		for (int i = 0; i < len; i++) {
			int temp = s.charAt(i) - '0';

			if (temp < 0 || temp > 9)
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(solution("a234"));
		System.out.println(solution("1234"));
	}

}
