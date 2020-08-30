import java.util.*;

public class Solution_gymclothes {

	public static int solution(int n, int[] lost, int[] reserve) {
		if (lost.length == 0)
			return n;

		int answer = n - lost.length;
		LinkedList<Integer> lostP = new LinkedList<>();
		LinkedList<Integer> reserveP = new LinkedList<>();

		Arrays.sort(lost);
		Arrays.sort(reserve);

		for (int i = 0; i < lost.length; i++)
			lostP.add(lost[i]);

		for (int i = 0; i < reserve.length; i++)
			reserveP.add(reserve[i]);

		for (int i = 0; i < lost.length; i++) {
			if (reserveP.contains(new Integer(lost[i]))) {
				reserveP.remove(new Integer(lost[i]));
				lostP.remove(new Integer(lost[i]));
				answer++;
			}
		}

		while (!reserveP.isEmpty() && !lostP.isEmpty()) {
			int re = reserveP.poll();
			int lo = lostP.poll();

			if ((re - 1) == lo || lo == (re + 1))
				answer++;
			else if (re - 1 > lo)
				reserveP.addFirst(re);
			else if (re + 1 < lo)
				lostP.addFirst(lo);
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(5, new int[] { 2, 4 }, new int[] { 1, 3, 5 }));
		System.out.println(solution(5, new int[] { 2, 4 }, new int[] { 3 }));
		System.out.println(solution(3, new int[] { 3 }, new int[] { 1 }));
		System.out.println(solution(4, new int[] { 5, 6 }, new int[] { 4, 5 }));
	}

}
