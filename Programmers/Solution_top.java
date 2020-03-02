import java.util.*;

public class Solution_top {
	
	public static int[] solution(int[] heights) {
		int idx = heights.length;
		int[] answer = new int[idx];
		Stack<Top> stack = new Stack<>();
		Stack<Top> wait = new Stack<>();

		for (int i = 0; i < heights.length; i++)
			stack.push(new Top(i, heights[i]));

		Arrays.fill(answer, 0);

		while (!stack.isEmpty()) {
			wait.push(stack.pop());
			idx--;

			if (stack.size() <= 0 || stack.peek().height <= wait.peek().height)
				continue;
			else {
				while (wait.size() > 0 && stack.peek().height > wait.peek().height)
					answer[wait.pop().idx] = idx;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] { 6, 9, 5, 7, 4 })));
		System.out.println(Arrays.toString(solution(new int[] { 3, 9, 9, 3, 5, 7, 2 })));
		System.out.println(Arrays.toString(solution(new int[] { 1, 5, 3, 6, 7, 6, 5 })));
	}
}

class Top {
	int idx, height;

	public Top(int idx, int height) {
		this.idx = idx;
		this.height = height;
	}
}