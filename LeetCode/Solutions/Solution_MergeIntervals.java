import java.util.*;

public class Solution_MergeIntervals {

	public static int[][] merge(int[][] intervals) {
		int len = intervals.length;

		if (len <= 1)
			return intervals;

		Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

		List<int[]> answer = new ArrayList<>();

		int[] temp = intervals[0];
		int idx = 1;

		while (idx < len) {
			while (idx < len && temp[1] >= intervals[idx][0]) {
				temp[1] = Math.max(temp[1], intervals[idx][1]);
				++idx;
			}

			answer.add(new int[] { temp[0], Math.max(temp[1], intervals[idx - 1][1]) });

			if (idx < len)
				temp = intervals[idx];
		}

		return answer.toArray(new int[answer.size()][2]);
	}

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(merge(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } })));
		System.out.println(Arrays.deepToString(merge(new int[][] { { 1, 4 }, { 4, 5 } })));
		System.out.println(Arrays.deepToString(merge(new int[][] { { 1, 3 } })));
		System.out.println(Arrays.deepToString(merge(new int[][] { { 1, 3 }, { 2, 6 } })));
		System.out.println(Arrays.deepToString(merge(new int[][] { { 1, 3 }, { 3, 6 } })));
		System.out.println(Arrays.deepToString(merge(new int[][] { { 1, 3 }, { 4, 6 } })));
		System.out.println(Arrays.deepToString(merge(new int[][] { { 1, 4 }, { 2, 3 } })));
		System.out.println(Arrays.deepToString(merge(new int[][] { { 1, 4 }, { 0, 2 }, { 3, 5 } })));
	}
}
