import java.util.*;

public class Solution_SequentialDigits {
	static int range = 10;

//	public static void DFS(List<Integer> answer, int curN, int low, int high, int n) {
//		if (low <= curN && curN <= high)
//			answer.add(curN);
//
//		if (curN > high || n == 10)
//			return;
//
//		DFS(answer, curN * 10 + n, low, high, n + 1);
//	}

	public static void BFS(List<Integer> answer, int low, int high) {
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i < range; ++i)
			queue.offer(i);

		while (!queue.isEmpty()) {
			int curN = queue.poll();
			int nextN = curN % 10 + 1;

			if (nextN == 10)
				continue;

			int value = curN * 10 + nextN;

			if (value > high)
				continue;

			if (low <= value && value <= high)
				answer.add(value);

			queue.offer(value);
		}
	}

	public static List<Integer> sequentialDigits(int low, int high) {
		List<Integer> answer = new ArrayList<>();

//		for (int i = 1; i < range; ++i)
//			DFS(answer, 0, low, high, i);
//
//		Collections.sort(answer);

		BFS(answer, low, high);

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(sequentialDigits(100, 300)); // [123,234]
		System.out.println(sequentialDigits(1000, 13000)); // [1234,2345,3456,4567,5678,6789,12345]
	}
}
