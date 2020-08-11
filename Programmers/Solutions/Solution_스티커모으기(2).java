
public class Solution_collectsticker2 {

	public static int solution(int[] sticker) {
		int len = sticker.length;
		int[] score = new int[len];

		if(len == 1)
			return sticker[0];
		
		if(len == 2)
			return Math.max(sticker[0], sticker[1]);
		
		score[0] = sticker[0];
		score[1] = score[0];
		
		int answer = score[0];

		for (int i = 2; i < len - 1; i++) {
			score[i] = Math.max(score[i - 1], score[i - 2] + sticker[i]);
			answer = Math.max(answer, score[i]);
		}

		score[0] = 0;
		score[1] = sticker[1];

		for (int i = 2; i < len; i++) {
			score[i] = Math.max(score[i - 1], score[i - 2] + sticker[i]);
			answer = Math.max(answer, score[i]);
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 14, 6, 5, 11, 3, 9, 2, 10 }));
		System.out.println(solution(new int[] { 1, 3, 2, 5, 4 }));
	}

}
