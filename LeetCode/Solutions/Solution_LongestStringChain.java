import java.util.*;

public class Solution_LongestStringChain {

//	public static int longestStrChain(String[] words) {
//		int size = 17;
//		List<String>[] bucket = new ArrayList[size];
//
//		for (int i = 0; i < size; ++i)
//			bucket[i] = new ArrayList<>();
//
//		int max_len = 0;
//		for (String word : words) {
//			int wlen = word.length();
//
//			bucket[wlen].add(word);
//			max_len = Math.max(max_len, wlen);
//		}
//
//		int answer = 0;
//
//		for (int i = max_len; i > 1 && i > answer; --i)
//			answer = Math.max(answer, DFS(bucket, i, null));
//
//		return answer;
//	}
//
//	public static int DFS(List<String>[] bucket, int len, String prev) {
//		List<String> str_list = bucket[len];
//
//		if (str_list.size() == 0)
//			return 0;
//
//		int max_len = 0;
//		for (String str : str_list) {
//			if (!isPrev(str, prev))
//				continue;
//
//			max_len = Math.max(max_len, DFS(bucket, len - 1, str) + 1);
//		}
//
//		return max_len;
//	}
//
//	public static boolean isPrev(String current, String prev) {
//		if (prev == null)
//			return true;
//
//		int clen = current.length(), plen = prev.length();
//		int cidx = 0, pidx = 0;
//
//		while (cidx < clen && pidx < plen) {
//			if (current.charAt(cidx) == prev.charAt(pidx)) {
//				++cidx;
//				++pidx;
//			} else {
//				++pidx;
//
//				if (pidx - cidx > 1)
//					return false;
//			}
//		}
//
//		return pidx - cidx <= 1;
//	}

	public static int longestStrChain(String[] words) {
		Arrays.sort(words, (a, b) -> (a.length() - b.length()));

		Map<String, Integer> table = new HashMap<>();

		int max_len = 0;
		for (String word : words) {
			table.put(word, 1);

			int wlen = word.length();

			for (int i = 0; i < wlen; ++i) {
				StringBuilder sb = new StringBuilder(word);
				String prev = sb.deleteCharAt(i).toString();

				if (!table.containsKey(prev) || (table.get(prev) + 1 <= table.get(word)))
					continue;

				table.put(word, table.get(prev) + 1);
			}

			max_len = Math.max(max_len, table.get(word));
		}

		return max_len;
	}

	public static void main(String[] args) {
		System.out.println(longestStrChain(new String[] { "a", "b", "ba", "bca", "bda", "bdca" })); // 4
		System.out.println(longestStrChain(
				new String[] { "ksqvsyq", "ks", "kss", "czvh", "zczpzvdhx", "zczpzvh", "zczpzvhx", "zcpzvh", "zczvh",
						"gr", "grukmj", "ksqvsq", "gruj", "kssq", "ksqsq", "grukkmj", "grukj", "zczpzfvdhx", "gru" })); // 7
	}
}
