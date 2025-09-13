import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1516 {

	public static int[] topologicalSort(int N, List<Integer>[] adjList, int[] inDeg, int[] costs) {
		int[] maxCosts = new int[N + 1];
		Queue<Integer> queue = new ArrayDeque<>();

		for (int i = 1; i <= N; ++i) {
			if (inDeg[i] == 0) {
				queue.offer(i);
				maxCosts[i] = costs[i];
			}
		}

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int next : adjList[current]) {
				maxCosts[next] = Math.max(maxCosts[next], maxCosts[current] + costs[next]);
				--inDeg[next];

				if (inDeg[next] == 0) {
					queue.offer(next);
				}
			}
		}

		return maxCosts;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] inDeg = new int[N + 1];
		int[] costs = new int[N + 1];
		List<Integer>[] adjList = new ArrayList[N + 1];

		for (int i = 1; i <= N; ++i) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine());
			costs[i] = Integer.parseInt(st.nextToken());

			while (true) {
				int preNode = Integer.parseInt(st.nextToken());

				if (preNode == -1) {
					break;
				}

				adjList[preNode].add(i);
				++inDeg[i];
			}
		}

		int[] maxCosts = topologicalSort(N, adjList, inDeg, costs);

		for (int i = 1; i <= N; ++i) {
			System.out.println(maxCosts[i]);
		}
	}
}
