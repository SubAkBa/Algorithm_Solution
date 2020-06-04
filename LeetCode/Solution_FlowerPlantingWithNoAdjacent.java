import java.util.*;

public class Solution_FlowerPlantingWithNoAdjacent {

	public static int[] gardenNoAdj(int N, int[][] paths) {
		int[] answer = new int[N];

		if (paths.length == 0) {
			Arrays.fill(answer, 1);
			return answer;
		}

		ArrayList<Integer>[] adj = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++)
			adj[i] = new ArrayList<>();

		for (int i = 0; i < paths.length; i++) {
			adj[paths[i][0]].add(paths[i][1]);
			adj[paths[i][1]].add(paths[i][0]);
		}

		for (int from = 1; from <= N; from++) {
			HashSet<Integer> set = new HashSet<>();

			for (int to : adj[from])
				set.add(answer[to - 1]);

			for (int flowertype = 1; flowertype <= 4; flowertype++) {
				if (!set.contains(flowertype))
					answer[from - 1] = flowertype;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(gardenNoAdj(3, new int[][] { { 1, 2 }, { 2, 3 }, { 3, 1 } })));
		System.out.println(Arrays.toString(gardenNoAdj(4, new int[][] { { 1, 2 }, { 3, 4 } })));
		System.out.println(Arrays
				.toString(gardenNoAdj(4, new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 1 }, { 1, 3 }, { 2, 4 } })));
		System.out.println(Arrays
				.toString(gardenNoAdj(5, new int[][] { { 3, 4 }, { 4, 5 }, { 3, 2 }, { 5, 1 }, { 1, 3 }, { 4, 2 } })));
	}

}
