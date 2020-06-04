import java.util.*;

public class Solution_SortIntegersbyThePowerValue {

	public static int Save(HashMap<Integer, Integer> steps, int num) {
		if (num == 2)
			return 1;

		if (steps.containsKey(num))
			return steps.get(num);

		if (num % 2 == 0)
			steps.put(num, Save(steps, num / 2) + 1);
		else
			steps.put(num, Save(steps, num * 3 + 1) + 1);

		return steps.get(num);
	}

	public static int getKth(int lo, int hi, int k) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
		HashMap<Integer, Integer> steps = new HashMap<>();

		for (int i = lo; i <= hi; i++)
			pq.offer(new int[] { i, Save(steps, i) });

		while (!pq.isEmpty() && k-- > 1)
			pq.poll();

		return pq.poll()[0];
	}

	public static void main(String[] args) {
		System.out.println(getKth(12, 15, 2));
		System.out.println(getKth(1, 1, 1));
		System.out.println(getKth(7, 11, 4));
		System.out.println(getKth(10, 20, 5));
		System.out.println(getKth(1, 1000, 777));
	}

}
