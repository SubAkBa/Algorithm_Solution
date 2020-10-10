import java.util.*;

public class Solution_AllPathsFromSourcetoTarget {

	public void DFS(List<List<Integer>> answer, List<Integer> path, int[][] graph, int node, int n) {
		if (node == n - 1) {
			answer.add(new ArrayList<>(path));
			return;
		}

		for (int next : graph[node]) {
			path.add(next);
			DFS(answer, path, graph, next, n);
			path.remove(path.size() - 1);
		}
	}

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> answer = new ArrayList<>();
		int N = graph.length;

		List<Integer> path = new ArrayList<>();
		path.add(0);
		DFS(answer, path, graph, 0, N);

		return answer;
	}
}
