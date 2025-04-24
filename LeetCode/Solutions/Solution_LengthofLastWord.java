public class Solution_LengthofLastWord {
	public static int lengthOfLastWord(String s) {
		String[] s1 = s.split(" ");

		return s1[s1.length - 1].length();
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("Hello World")); // 5
		System.out.println(lengthOfLastWord("   fly me   to   the moon  ")); // 4
		System.out.println(lengthOfLastWord("luffy is still joyboy")); // 6
	}
}
