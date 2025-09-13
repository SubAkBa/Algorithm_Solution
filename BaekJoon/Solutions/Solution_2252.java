import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2252 {

	public static String topologicalSort(int N, List<Integer>[] adjList, int[] inDeg) {
		Queue<Integer> queue = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; ++i) {
			if (inDeg[i] == 0) {
				queue.offer(i);
				sb.append(i + " ");
			}
		}

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int next : adjList[current]) {
				--inDeg[next];

				if (inDeg[next] == 0) {
					queue.offer(next);
					sb.append(next + " ");
				}
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer>[] adjList = new ArrayList[N + 1];
		int[] inDeg = new int[N + 1];

		for (int i = 1; i <= N; ++i) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			adjList[A].add(B);
			++inDeg[B];
		}

		System.out.println(topologicalSort(N, adjList, inDeg));
	}
}