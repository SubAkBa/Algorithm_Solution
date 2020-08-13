import java.util.*;

public class Solution_JumpGameIII {

	public static boolean canReach(int[] arr, int start) {
		if (arr[start] == 0)
			return true;
		
		Queue<Integer> queue = new LinkedList<>();
		int len = arr.length;
		boolean[] visited = new boolean[len];

		queue.offer(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int curidx = queue.poll();

			if (0 <= (curidx - arr[curidx]) && !visited[curidx - arr[curidx]]) {
				if (arr[curidx - arr[curidx]] == 0)
					return true;

				queue.offer(curidx - arr[curidx]);
				visited[curidx - arr[curidx]] = true;
			}

			if ((curidx + arr[curidx]) < len && !visited[curidx + arr[curidx]]) {
				if (arr[curidx + arr[curidx]] == 0)
					return true;

				queue.offer(curidx + arr[curidx]);
				visited[curidx + arr[curidx]] = true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(canReach(new int[] { 4, 2, 3, 0, 3, 1, 2 }, 5));
		System.out.println(canReach(new int[] { 4, 2, 3, 0, 3, 1, 2 }, 0));
		System.out.println(canReach(new int[] { 3, 0, 2, 1, 2 }, 2));
		System.out.println(canReach(new int[] { 0 }, 0));
	}

}
