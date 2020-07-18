import java.util.*;
import java.io.*;

public class Solution_17412 {
	static ArrayList<Integer>[] adj;
	static int N, P;
	static int[][] capacity, flow;

	public static int Network_Flow(int source, int sink) {
		Queue<Integer> queue = new LinkedList<>();
		int[] prev = new int[N + 1];
		int count = 0;

		while (true) {
			Arrays.fill(prev, -1);

			queue.offer(source);

			while (!queue.isEmpty()) {
				int from = queue.poll();

				for (int to : adj[from]) {
					if (capacity[from][to] - flow[from][to] > 0 && prev[to] == -1) {
						prev[to] = from;
						queue.offer(to);
					}
				}
			}

			if (prev[sink] == -1)
				break;

			for (int i = sink; i != source; i = prev[i]) {
				++flow[prev[i]][i];
				--flow[i][prev[i]];
			}

			++count;
		}

		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N + 1];
		capacity = new int[N + 1][N + 1];
		flow = new int[N + 1][N + 1];

		for (int i = 1; i <= N; ++i)
			adj[i] = new ArrayList<>();

		for (int i = 0; i < P; ++i) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			adj[from].add(to);
			adj[to].add(from);
			capacity[from][to] = 1;
		}

		bw.write(Network_Flow(1, 2) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
