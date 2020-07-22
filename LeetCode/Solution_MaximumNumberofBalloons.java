public class Solution_MaximumNumberofBalloons {

	public static int maxNumberOfBalloons(String text) {
		int[] counts = new int[26];
		int len = text.length(), answer = Integer.MAX_VALUE;
		String target = "banlo";

		for (char t : text.toCharArray())
			++counts[t - 'a'];

		for (int i = 0; i < 5; ++i) {
			char c = target.charAt(i);
			if (i < 3)
				answer = Math.min(answer, counts[c - 'a']);
			else
				answer = Math.min(answer, counts[c - 'a'] / 2);
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(maxNumberOfBalloons("nlaebolko"));
		System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
		System.out.println(maxNumberOfBalloons("leetcode"));
	}
}
