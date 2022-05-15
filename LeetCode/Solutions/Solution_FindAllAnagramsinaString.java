import java.util.*;

public class Solution_FindAllAnagramsinaString {
	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> idxlist = new ArrayList<>();
		int plen = p.length(), slen = s.length(), left = 0, right = 0;
		int[] parr = new int[26];

		if (slen == 0 || plen == 0 || slen < plen)
			return idxlist;

		for (int i = 0; i < plen; ++i)
			++parr[p.charAt(i) - 'a'];

		while (left <= right && right < slen) {
			--parr[s.charAt(right) - 'a'];

			while (parr[s.charAt(right) - 'a'] < 0 && left <= right) {
				++parr[s.charAt(left) - 'a'];
				++left;
			}

			++right;

			if ((right - left) == plen)
				idxlist.add(left);
		}

		return idxlist;
	}

	public static void main(String[] args) {
		System.out.println(findAnagrams("cbaebabacd", "abc"));
		System.out.println(findAnagrams("abab", "ab"));
		System.out.println(findAnagrams("", "a"));
		System.out.println(findAnagrams("a", ""));
		System.out.println(findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa"));
	}

}
