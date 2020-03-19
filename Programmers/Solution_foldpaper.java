import java.util.*;

public class Solution_foldpaper {

	public static int[] solution(int n) {
		StringBuilder sb = new StringBuilder("0");

		while ((--n) > 0) {
			String str = sb.toString();
			
			sb.append(0);
			
			for (int i = str.length() - 1; i >= 0; i--) {
				if (str.charAt(i) == '1')
					sb.append(0);
				else
					sb.append(1);
			}
		}

		int[] result = new int[sb.length()];

		for (int i = 0; i < result.length; i++)
			result[i] = sb.charAt(i) - '0';

		return result;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(1)));
		System.out.println(Arrays.toString(solution(2)));
		System.out.println(Arrays.toString(solution(3)));
	}

}
