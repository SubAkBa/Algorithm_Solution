import java.util.*;

public class Solution_spicier {

	public static int solution(int[] scoville, int K) {
		int answer = 0, len = scoville.length;
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < len; i++)
			pq.offer(scoville[i]);

		while (true) {
			int first = pq.poll();

			if (first >= K)
				break;
			else if (pq.isEmpty()) {
				answer = -1;
				break;
			}

			int second = pq.poll();

			pq.offer(first + (second * 2));

			answer++;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 2, 3, 9, 10, 12 }, 7));
		System.out.println(solution(new int[] { 1, 2, 3, 4, 5, 6 }, 72));
	}

}
