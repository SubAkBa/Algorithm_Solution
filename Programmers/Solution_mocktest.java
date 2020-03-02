
import java.util.*;

public class Solution_mocktest {

	public static int[] solution(int[] answers) {
		int[] score = new int[3];
		int[] answer = new int[3], pt2 = { 1, 3, 4, 5 }, pt3 = { 3, 1, 2, 4, 5 };
		int max = 0;

		Arrays.fill(score, 0);

		for (int i = 0; i < answers.length; i++) {

			if (answers[i] == ((i % 5)) + 1)
				score[0]++;

			max = Math.max(max, score[0]);

			if ((i % 2 == 0 && answers[i] == 2) || (i % 2 == 1 && answers[i] == pt2[(i % 8) / 2]))
				score[1]++;

			max = Math.max(max, score[1]);

			if (pt3[(i % 10) / 2] == answers[i])
				score[2]++;

			max = Math.max(max, score[2]);
		}

		for (int i = 0; i < score.length; i++) {
			if (max == score[i])
				answer[i] = i + 1;
		}

		return Arrays.stream(answer).filter(i -> i != 0).toArray();
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] { 1, 2, 3, 4, 5 })));
		System.out.println(Arrays.toString(solution(new int[] { 1, 3, 2, 4, 2 })));
		System.out.println(Arrays.toString(solution(new int[] { 1, 3, 2, 4, 2, 2, 3, 4, 3, 2, 3, 1, 5, 1 })));
	}
}
