import java.util.*;

public class Solution_RemoveAllAdjacentDuplicatesInString {

	public static String removeDuplicates(String S) {
		int len = S.length(), idx = -1;
		char[] ch = new char[len];

		for (int i = 0; i < len; i++) {
			if (idx == -1 || ch[idx] != S.charAt(i))
				ch[++idx] = S.charAt(i);
			else
				idx--;
		}

		return String.valueOf(ch, 0, idx + 1);
	}

//	public static String removeDuplicates(String S) {
//		Stack<Character> stack = new Stack<>();
//		int len = S.length();
//		StringBuilder sb = new StringBuilder();
//
//		for (int i = 0; i < len; i++) {
//			char ch = S.charAt(i);
//
//			if (stack.isEmpty())
//				stack.push(ch);
//			else {
//				if (stack.peek() == ch)
//					stack.pop();
//				else
//					stack.push(ch);
//			}
//		}
//
//		while (!stack.isEmpty())
//			sb.append(stack.pop());
//
//		return sb.reverse().toString();
//	}

	public static void main(String[] args) {
		System.out.println(removeDuplicates("abbaca"));
	}

}
