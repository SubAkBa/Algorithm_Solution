
public class Solution_IsomorphicStrings {

	public static boolean isIsomorphic(String s, String t) {
		int len = s.length();
		int[] smap = new int[128];
		int[] tmap = new int[128];

		for (int i = 0; i < len; ++i) {
			char sc = s.charAt(i);
			char tc = t.charAt(i);

			if (smap[sc] != tmap[tc])
				return false;

			smap[sc] = i + 1;
			tmap[tc] = i + 1;
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(isIsomorphic("egg", "add"));
		System.out.println(isIsomorphic("foo", "bar"));
		System.out.println(isIsomorphic("paper", "title"));
		System.out.println(isIsomorphic("abba", "abab"));
		System.out.println(isIsomorphic("ab", "aa"));
	}

}
