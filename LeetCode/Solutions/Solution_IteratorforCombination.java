import java.util.*;

public class Solution_IteratorforCombination {

	class CombinationIterator {
		List<String> combination = new LinkedList<>();
		int range;

		public CombinationIterator(String characters, int combinationLength) {
			range = combinationLength;

			if (range > 0)
				Create_Combination(characters, new StringBuilder(), 0, 0, characters.length());
		}

		public String next() {
			return combination.remove(0);
		}

		public boolean hasNext() {
			return !combination.isEmpty();
		}

		public void Create_Combination(String characters, StringBuilder sb, int idx, int len, int char_len) {
			if (range == len) {
				combination.add(sb.toString());
				return;
			}

			if (range < len)
				return;

			for (int i = idx; i < char_len; ++i) {
				sb.append(characters.charAt(i));
				Create_Combination(characters, sb, i + 1, len + 1, char_len);
				sb.deleteCharAt(len);
			}
		}
	}
}
