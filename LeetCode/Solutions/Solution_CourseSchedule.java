import java.util.*;

public class Solution_CourseSchedule {

	public static boolean Finishing(ArrayList<Integer>[] adj, int[] indeg, int len) {
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < len; ++i) {
			if (indeg[i] == 0)
				queue.offer(i);
		}

		for (int i = 0; i < len; ++i) {
			if (queue.size() == 0)
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
		ArrayList<Integer>[] adj = new ArrayList[numCourses];
		int[] indeg = new int[numCourses];
		int plen = prerequisites.length;

		for (int i = 0; i < numCourses; ++i)
			adj[i] = new ArrayList<>();

		for (int i = 0; i < plen; ++i) {
			adj[prerequisites[i][1]].add(prerequisites[i][0]);
			++indeg[prerequisites[i][0]];
		}

		return Finishing(adj, indeg, numCourses);
	}

	public static void main(String[] args) {
		System.out.println(canFinish(2, new int[][] { { 1, 0 } }));
		System.out.println(canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } }));
	}

}
