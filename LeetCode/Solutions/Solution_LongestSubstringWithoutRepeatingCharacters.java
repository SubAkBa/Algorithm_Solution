
public class Solution_LongestSubstringWithoutRepeatingCharacters {

	public static int lengthOfLongestSubstring(String s) {
		int slen = s.length();
		int[] counts = new int[128];

		int answer = 0;
		int left = 0, right = 0;
		
		while (right < slen) {
			if (counts[s.charAt(right)] == 0)
				++counts[s.charAt(right)];
			else {
				answer = Math.max(answer, right - left);

				while (left < right && counts[s.charAt(right)] > 0) {
					--counts[s.charAt(left)];
					++left;
				}

				++counts[s.charAt(right)];
			}

			++right;

		}

		answer = Math.max(answer, right - left);

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
		System.out.println(lengthOfLongestSubstring("bbbbb")); // 1
		System.out.println(lengthOfLongestSubstring("pwwkew")); // 3
		System.out.println(lengthOfLongestSubstring(" ")); // 1
		System.out.println(lengthOfLongestSubstring("dvdf")); // 3
	}
}
