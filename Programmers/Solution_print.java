import java.util.*;

public class Solution_print {

	public static int solution(int[] priorities, int location) {
		int answer = 0, idx = priorities.length - 1;
		Queue<Doc> queue = new LinkedList<>();

		for (int i = 0; i <= idx; i++)
			queue.offer(new Doc(i, priorities[i]));

		Arrays.sort(priorities);

		while (true) {
			Doc cur = queue.poll();

			if (cur.importance == priorities[idx]) {
				idx--;
				if (cur.idx == location) {
					answer = priorities.length - idx - 1;
					break;
				}
			} else
				queue.offer(cur);
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 2, 1, 3, 2 }, 2));
		System.out.println(solution(new int[] { 1, 1, 9, 1, 1, 1 }, 0));
	}
}

class Doc {
	int idx, importance;

	public Doc(int idx, int importance) {
		this.idx = idx;
		this.importance = importance;
	}
}