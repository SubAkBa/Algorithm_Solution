public class Solution_thelongestpalindrome {

	public static int solution(String s) {
		int slen = s.length();
		char[] chr = new char[slen * 2 + 1];

		chr[0] = '#';

		for (int i = 0; i < slen; i++) {
			chr[2 * i + 1] = s.charAt(i);
			chr[2 * i + 2] = '#';
		}

		int clen = chr.length;
		int[] rad = new int[clen];
		int cent = 0, right = 0, answer = -1;

		for (int i = 0; i < clen; i++) {
			if (i <= right)
				rad[i] = Math.min(right - i, rad[2 * cent - i]);

			while ((0 <= i - rad[i] - 1) && (i + rad[i] + 1 < clen) && chr[i - rad[i] - 1] == chr[i + rad[i] + 1])
				rad[i]++;

			if (right < i + rad[i]) {
				right = i + rad[i];
				cent = i;
			}

			answer = Math.max(answer, rad[i]);
		}

		return answer;

	}

	public static void main(String[] args) {
		System.out.println(solution("abcdcba"));
		System.out.println(solution("abacde"));
	}

}
