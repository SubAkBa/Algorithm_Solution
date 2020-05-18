import java.util.*;

public class Solution_RemoveDuplicateLetters {
	static final int ALPHABET_SIZE = 26;

	public static String removeDuplicateLetters(String s) {
		int[] count = new int[ALPHABET_SIZE];
		boolean[] selected = new boolean[ALPHABET_SIZE];
		Stack<Character> stack = new Stack<>();
		int len = s.length();

		for (int i = 0; i < len; i++)
			count[s.charAt(i) - 'a']++;

		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			
			count[c - 'a']--;

			if (selected[c - 'a'])
				continue;

			while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0)
				selected[stack.pop() - 'a'] = false;

			selected[c - 'a'] = true;
			stack.push(c);
		}

		StringBuilder sb = new StringBuilder();

		while (!stack.isEmpty())
			sb.append(stack.pop());

		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(removeDuplicateLetters("bcccaccb")); // acb
		System.out.println(removeDuplicateLetters("bcabc")); // abc
		System.out.println(removeDuplicateLetters("cbacdcbc")); // acdb
		System.out.println(removeDuplicateLetters("cbacbcdc")); // abcd
	}

}
