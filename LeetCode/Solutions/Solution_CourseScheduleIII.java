import java.util.*;

public class Solution_CourseScheduleIII {

	public static int scheduleCourse(int[][] courses) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
		int day = 0;

		Arrays.sort(courses, (a, b) -> a[1] - b[1]);

		for (int[] course : courses) {
			if (day + course[0] <= course[1]) {
				pq.offer(course[0]);
				day += course[0];
			} else if (!pq.isEmpty() && (pq.peek() > course[0])) {
				day += course[0] - pq.poll();
				pq.offer(course[0]);
			}
		}

		return pq.size();
	}

	public static void main(String[] args) {
		System.out.println(scheduleCourse(new int[][] { { 100, 200 }, { 200, 1300 }, { 1000, 1250 }, { 2000, 3200 } })); // 3
		System.out.println(scheduleCourse(new int[][] { { 5, 5 }, { 2, 6 }, { 4, 6 } })); // 2
		System.out.println(scheduleCourse(
				new int[][] { { 7, 17 }, { 3, 12 }, { 10, 20 }, { 9, 10 }, { 5, 20 }, { 10, 19 }, { 4, 18 } })); // 4
		System.out.println(scheduleCourse(new int[][] { { 5, 11 }, { 3, 5 }, { 10, 20 }, { 4, 20 }, { 10, 16 } })); // 3
	}

}
