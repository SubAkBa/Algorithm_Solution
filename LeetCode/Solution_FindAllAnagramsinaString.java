import java.util.*;

public class Solution_FindAllAnagramsinaString {
	public static List<Integer> findAnagrams(String s, String p) {
		LinkedList<Integer> idxlist = new LinkedList<>();
		int plen = p.length(), slen = s.length();
		int[] parr = new int[26], sarr = new int[26];
		
		if(slen == 0 || plen == 0 || slen < plen)
			return idxlist;

		for (int i = 0; i < plen; i++) {
			sarr[s.charAt(i) - 'a']++;
			parr[p.charAt(i) - 'a']++;
		}

		if (Arrays.equals(sarr, parr))
			idxlist.add(0);

		for (int i = plen; i < slen; i++) {
			sarr[s.charAt(i - plen) - 'a']--;
			sarr[s.charAt(i) - 'a']++;

			if (Arrays.equals(sarr, parr))
				idxlist.add(i - plen + 1);
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
