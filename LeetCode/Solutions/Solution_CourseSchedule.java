import java.util.*;

public class Solution_CourseSchedule {

	public static boolean Topological_Sort(int numCourses, List<Integer>[] adj, int[] indeg) {
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < numCourses; ++i) {
			if (indeg[i] == 0)
				queue.offer(i);
		}

		for (int i = 0; i < numCourses; ++i) {
			if (queue.isEmpty())
				return false;

			int from = queue.poll();

			for (int to : adj[from]) {
				if ((--indeg[to]) == 0)
					queue.offer(to);
			}
		}

		return true;
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] indeg = new int[numCourses];
		List<Integer>[] adj = new ArrayList[numCourses];

		int plen = prerequisites.length;

		for (int i = 0; i < numCourses; ++i)
			adj[i] = new ArrayList<>();

		for (int i = 0; i < plen; ++i) {
			adj[prerequisites[i][1]].add(prerequisites[i][0]);
			++indeg[prerequisites[i][0]];
		}

		return Topological_Sort(numCourses, adj, indeg);
	}

	public static void main(String[] args) {
		System.out.println(canFinish(2, new int[][] { { 1, 0 } })); // true
		System.out.println(canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } })); // false
	}
}