import java.util.*;

public class Solution_englishwordchain {

	public static int[] solution(int n, String[] words) {
		int len = words.length;
		HashSet<String> set = new HashSet<>();
		int[] answer = new int[] {0, 0};

		set.add(words[0]);
		for (int i = 1; i < len; i++) {
			
			if (set.contains(words[i]) || words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
				answer = new int[] { i % n + 1, i / n + 1 };
				break;
			}

			set.add(words[i]);
		}

		return (answer == null ? new int[] { 0, 0 } : answer);
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(3,
				new String[] { "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank" })));
		System.out.println(Arrays.toString(
				solution(5, new String[] { "hello", "observe", "effect", "take", "either", "recognize", "encourage",
						"ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive" })));
		System.out.println(
				Arrays.toString(solution(2, new String[] { "hello", "one", "even", "never", "now", "world", "draw" })));
	}

}
