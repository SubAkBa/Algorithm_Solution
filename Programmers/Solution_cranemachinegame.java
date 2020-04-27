import java.util.*;

public class Solution_cranemachinegame {

	public static int solution(int[][] board, int[] moves) {
		Stack<Integer> stack = new Stack<>();
		int answer = 0, N = board.length, moving = moves.length;

		for (int i = 0; i < moving; i++) {
			int idx = 0;

			while (idx < N && board[idx][moves[i] - 1] == 0)
				idx++;

			if (idx == N)
				continue;

			int doll = board[idx][moves[i] - 1];
			board[idx][moves[i] - 1] = 0;
			
			if (stack.isEmpty())
				stack.push(doll);
			else {
				if (stack.peek() == doll) {
					stack.pop();
					answer += 2;
				} else
					stack.push(doll);
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 },
				{ 4, 2, 4, 4, 2 }, { 3, 5, 1, 3, 1 } }, new int[] { 1, 5, 3, 5, 1, 2, 1, 4 }));
	}

}
