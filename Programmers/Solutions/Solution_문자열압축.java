
public class Solution_문자열압축 {

	public static int solution(String s) {
		int len = s.length();
		int answer = len;

		for (int interval = 1; interval < len / 2 + 1; ++interval) {

			StringBuilder sb = new StringBuilder();

			int i = 0, j = interval;
			while (i < len) {
				int count = 1;
				while (j < len && s.substring(i, i + interval).equals(s.substring(j, Math.min(j + interval, len)))) {
					++count;
					j += interval;
				}

				if (count > 1)
					sb.append(count + "" + s.substring(i, i + interval));
				else
					sb.append(s.substring(i, Math.min(i + interval, len)));

				i = j;
				j = i + interval;
			}

			answer = Math.min(answer, sb.length());
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution("aabbaccc")); // 7
		System.out.println(solution("ababcdcdababcdcd")); // 9
		System.out.println(solution("abcabcdede")); // 8
		System.out.println(solution("abcabcabcabcdededededede")); // 14
		System.out.println(solution("xababcdcdababcdcd")); // 17
	}
}
