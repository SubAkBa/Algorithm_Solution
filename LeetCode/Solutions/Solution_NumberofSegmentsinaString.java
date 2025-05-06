public class Solution_NumberofSegmentsinaString {
	public static int countSegments(String s) {
		int count = 0, idx = 0;

		while (idx < s.length()) {
			char ch = s.charAt(idx);

			if (ch == ' ') {
				++idx;
				continue;
			}

			while (idx < s.length() && s.charAt(idx) != ' ') {
				++idx;
			}

			++count;
		}

		return count;
	}

	public static void main(String[] args) {
		System.out.println(countSegments("Hello, my name is John")); // 5
		System.out.println(countSegments("Hello")); // 1
		System.out.println(countSegments("")); // 0
		System.out.println(countSegments(", , , ,        a, eaefa")); // 6
	}
}
