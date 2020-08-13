
public class Solution_FirstUniqueCharacterinaString {
	public static int firstUniqChar(String s) {
		int len = s.length();
		char[] ch = s.toCharArray();
		int[] count = new int[26];

		for (int i = 0; i < len; ++i)
			++count[ch[i] - 'a'];

		for (int i = 0; i < len; ++i) {
			if (count[ch[i] - 'a'] == 1)
				return i;
		}

		return -1;
	}

	public static void main(String[] args) {
		System.out.println(firstUniqChar("leetcode"));
		System.out.println(firstUniqChar("loveleetcode"));
	}

}
