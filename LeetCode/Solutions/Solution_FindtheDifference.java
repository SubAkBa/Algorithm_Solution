
public class Solution_FindtheDifference {

	public static char findTheDifference(String s, String t) {
		int slen = s.length(), tlen = t.length();
		int sum = 0;

		for (int i = 0; i < slen; ++i) {
			sum ^= t.charAt(i);
			sum ^= s.charAt(i);
		}

		sum ^= t.charAt(tlen - 1);

		return (char) sum;
	}

	public static void main(String[] args) {
		System.out.println(findTheDifference("abcd", "abcde"));
	}
}
