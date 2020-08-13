
public class Solution_ValidAnagram {

	public static boolean isAnagram(String s, String t) {
		int SIZE = 26;
		int[] count = new int[SIZE];
		int slen = s.length(), tlen = t.length();

		if (slen != tlen)
			return false;

		for (int i = 0; i < slen; ++i)
			++count[s.charAt(i) - 'a'];

		for (int i = 0; i < slen; ++i) {
			if (--count[t.charAt(i) - 'a'] < 0)
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "nagaram"));
		System.out.println(isAnagram("rat", "car"));
	}

}
