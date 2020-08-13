
public class Solution_IsSubsequence {
	public static boolean isSubsequence(String s, String t) {
		int sidx = 0, slen = s.length(), tlen = t.length();

		if (slen > 0 && tlen == 0)
			return false;

		if (slen == 0 || tlen == 0)
			return true;

		for (int i = 0; i < tlen; ++i) {
			char sc = s.charAt(sidx);
			char tc = t.charAt(i);

			if (sc == tc) {
				if (++sidx == slen)
					return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(isSubsequence("abc", "ahbgdc"));
		System.out.println(isSubsequence("axc", "ahbgdc"));
	}
}
