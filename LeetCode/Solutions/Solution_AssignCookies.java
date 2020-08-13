import java.util.*;

public class Solution_AssignCookies {
	public static int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);

		int gidx = 0, sidx = 0;
		int glen = g.length, slen = s.length;
		int count = 0;

		while (gidx < glen && sidx < slen) {
			if (g[gidx] <= s[sidx]) {
				++count;
				++gidx;
				++sidx;
			} else
				++sidx;
		}

		return count;
	}

	public static void main(String[] args) {
		System.out.println(findContentChildren(new int[] { 1, 2, 3 }, new int[] { 1, 1 })); // 1
		System.out.println(findContentChildren(new int[] { 1, 2 }, new int[] { 1, 2, 3 })); // 2
		System.out.println(findContentChildren(new int[] { 10, 9, 8, 7 }, new int[] { 5, 6, 7, 8 })); // 2
	}

}
