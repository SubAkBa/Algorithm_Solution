import java.util.*;

public class Solution_CourseScheduleII {

	public static int[] CoursesOrder(ArrayList<Integer>[] adj, int[] indeg, int numCourses) {
		Queue<Integer> queue = new LinkedList<>();
		int[] order = new int[numCourses];
		int oidx = -1;

		for (int i = 0; i < numCourses; ++i) {
			if (indeg[i] == 0)
				queue.offer(i);
		}

		for (int i = 0; i < numCourses; ++i) {
			if (queue.size() == 0)
				return new int[] {};

			int from = queue.poll();

			order[++oidx] = from;
			for (int to : adj[from]) {
				if ((--indeg[to]) == 0)
					queue.offer(to);
			}
		}

		return order;
	}

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		ArrayList<Integer>[] adj = new ArrayList[numCourses];
		int[] indeg = new int[numCourses];
		int plen = prerequisites.length;

		for (int i = 0; i < numCourses; ++i)
			adj[i] = new ArrayList<>();

		for (int i = 0; i < plen; ++i) {
			adj[prerequisites[i][1]].add(prerequisites[i][0]);
			++indeg[prerequisites[i][0]];
		}

		return CoursesOrder(adj, indeg, numCourses);
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findOrder(2, new int[][] { { 1, 0 } })));
		System.out.println(Arrays.toString(findOrder(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } })));
		System.out.println(Arrays.toString(findOrder(2, new int[][] { { 1, 0 }, { 0, 1 } })));
	}

}
