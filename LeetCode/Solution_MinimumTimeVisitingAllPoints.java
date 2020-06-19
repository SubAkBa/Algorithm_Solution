
public class Solution_MinimumTimeVisitingAllPoints {

	public static int minTimeToVisitAllPoints(int[][] points) {
		int count = points.length;
		int time = 0;

		for (int i = 1; i < count; i++)
			time += Math.max(Math.abs(points[i - 1][0] - points[i][0]), Math.abs(points[i - 1][1] - points[i][1]));

		return time;
	}

	public static void main(String[] args) {
		System.out.println(minTimeToVisitAllPoints(new int[][] { { 1, 1 }, { 3, 4 }, { -1, 0 } }));
		System.out.println(minTimeToVisitAllPoints(new int[][] { { 3, 2 }, { -2, 2 } }));
		System.out.println(minTimeToVisitAllPoints(new int[][] { { 2, 2 } }));
	}

}
