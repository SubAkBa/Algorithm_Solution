
public class Solution_UniqueNumberofOccurrences {

	public static boolean uniqueOccurrences(int[] arr) {
		int clen = 2001;
		int[] counts = new int[clen];
		boolean[] existed = new boolean[clen / 2];

		for (int a : arr)
			++counts[a + 1000];

		for (int c : counts) {
			if (c == 0)
				continue;

			if (!existed[c])
				existed[c] = true;
			else
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(uniqueOccurrences(new int[] { 1, 2, 2, 1, 1, 3 }));
		System.out.println(uniqueOccurrences(new int[] { 1, 2 }));
		System.out.println(uniqueOccurrences(new int[] { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 }));
		System.out.println(uniqueOccurrences(new int[] { 26, 2, 16, 16, 5, 5, 26, 2, 5, 20, 20, 5, 2, 20, 2, 2, 20, 2,
				16, 20, 16, 17, 16, 2, 16, 20, 26, 16 }));
	}

}
