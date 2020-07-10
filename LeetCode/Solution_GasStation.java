
public class Solution_GasStation {

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int len = gas.length;
		int idx = 0, calc = 0;
		boolean not = false;

		for (int i = 0; i < len * 2; ++i) {
			calc += gas[i % len] - cost[i % len];

			if (calc < 0) {
				calc = 0;
				idx = i % len + 1;
			} else if (i == (idx + len - 1))
				break;

			if (i == 2 * len - 1)
				not = true;
		}

		return not ? -1 : idx;
	}

	public static void main(String[] args) {
		System.out.println(canCompleteCircuit(new int[] { 1, 2, 3, 4, 5 }, new int[] { 3, 4, 5, 1, 2 })); // 3
		System.out.println(canCompleteCircuit(new int[] { 2, 3, 4 }, new int[] { 3, 4, 3 })); // -1
		System.out.println(canCompleteCircuit(new int[] { 4, 3, 8, 6, 5 }, new int[] { 5, 8, 4, 7, 7 })); // -1
		System.out.println(canCompleteCircuit(new int[] { 3, 1, 1 }, new int[] { 1, 2, 2 })); // 0
	}

}
