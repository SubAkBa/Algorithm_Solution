import java.util.*;

public class Solution_ReorganizeString {

//	public static String reorganizeString(String S) {
//		int ALPHABET_SIZE = 26, len = S.length();
//		int[] count = new int[ALPHABET_SIZE];
//		PriorityQueue<OrgStr> pq = new PriorityQueue<>();
//
//		char[] ch = S.toCharArray();
//		for (char c : ch) {
//			count[c - 'a']++;
//		}
//
//		for (int i = 0; i < ALPHABET_SIZE; i++) {
//			if (count[i] > (len + 1) / 2)
//				return "";
//
//			if (count[i] == 0)
//				continue;
//
//			pq.offer(new OrgStr(count[i], (char) ('a' + i)));
//		}
//
//		StringBuilder sb = new StringBuilder();
//
//		while (pq.size() >= 2) {
//			OrgStr o1 = pq.poll();
//			OrgStr o2 = pq.poll();
//
//			sb.append(o1.c + "" + o2.c);
//
//			if ((--o1.count) > 0)
//				pq.offer(o1);
//
//			if ((--o2.count) > 0)
//				pq.offer(o2);
//		}
//
//		while (!pq.isEmpty())
//			sb.append(pq.poll().c);
//
//		return sb.toString();
//	}
//
//	public static class OrgStr implements Comparable<OrgStr> {
//		int count;
//		char c;
//
//		public OrgStr(int count, char c) {
//			this.count = count;
//			this.c = c;
//		}
//
//		public int compareTo(OrgStr o) {
//			return o.count - this.count;
//		}
//	}

	public static String reorganizeString(String S) {
		int ALPHABET_SIZE = 26, len = S.length(), max = 0;
		int[] count = new int[ALPHABET_SIZE];

		char[] ch = S.toCharArray();
		char[] result = new char[len];

		for (char c : ch) {
			count[c - 'a']++;

			if (count[c - 'a'] > count[max])
				max = c - 'a';
		}

		if (count[max] > (len + 1) / 2)
			return "";

		int idx = 0;

		while ((count[max]--) > 0) {
			result[idx] = (char) (max + 'a');
			idx += 2;
		}

		for (int i = 0; i < ALPHABET_SIZE; i++) {
			int co = count[i];

			while (co > 0) {
				if (idx >= len)
					idx = 1;

				result[idx] = (char) (i + 'a');
				idx += 2;
				co--;
			}
		}

		return String.valueOf(result);
	}

	public static void main(String[] args) {
		System.out.println(reorganizeString("aab"));
		System.out.println(reorganizeString("aaab"));
		System.out.println(reorganizeString("vvvlo"));
		System.out.println(reorganizeString("abcaabbadc"));
		System.out.println(reorganizeString("eqmeyggvp")); // "epeqgvgym"
	}

}
