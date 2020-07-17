import java.util.*;

public class Solution_ReverseString {

	public static char[] reverseString(char[] s) {
		int len = s.length;

		for (int i = 0; i < len / 2; ++i) {
			char c = s[i];
			s[i] = s[len - i - 1];
			s[len - i - 1] = c;
		}

		return s;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(reverseString(new char[] { 'h', 'e', 'l', 'l', 'o' })));
		System.out.println(Arrays.toString(reverseString(new char[] { 'H', 'a', 'n', 'n', 'a', 'h' })));
	}

}
