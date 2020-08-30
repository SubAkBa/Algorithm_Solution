
public class Solution_hidephonenumber {

	public static String solution(String phone_number) {
		StringBuilder sb = new StringBuilder();

		int len = phone_number.length();

		for (int i = 0; i < len - 4; i++)
			sb.append('*');
		
		sb.append(phone_number.substring(len - 4));
		
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(solution("01033334444"));
		System.out.println(solution("027778888"));
	}

}
