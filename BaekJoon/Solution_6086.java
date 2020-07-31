import java.util.*;
import java.io.*;

public class Solution_6086 {
	static int[][] capacity, flow;
	static int N, LEN = 52;

	public static int Maximum_Flow() {
		int[] prev = new int[LEN];
		int source = ctoi('A'), sink = ctoi('Z'), total = 0;

		while (true) {
			Queue<Integer> queue = new LinkedList<>();
			queue.offer(source);
			Arrays.fill(prev, -1);
			
			prev[source] = source;

			while (!queue.isEmpty() && prev[sink] == -1) {
				int from = queue.poll();

				for (int to = 0; to < LEN; ++to) {
					if (capacity[from][to] - flow[from][to] > 0 && prev[to] == -1) {
						prev[to] = from;
						queue.offer(to);
					}
				}
			}

			if (prev[sink] == -1)
				break;

			int min_flow = Integer.MAX_VALUE;

			for (int i = sink; i != source; i = prev[i])
				min_flow = Math.min(min_flow, capacity[prev[i]][i] - flow[prev[i]][i]);

			for (int i = sink; i != source; i = prev[i]) {
				flow[prev[i]][i] += min_flow;
				flow[i][prev[i]] -= min_flow;
			}

			total += min_flow;
		}

		return total;
	}

	public static int ctoi(char c) {
		if ('A' <= c && c <= 'Z')
			return c - 'A';

		return c - 'a' + 26;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());

		capacity = new int[LEN][LEN];
		flow = new int[LEN][LEN];

		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = ctoi(st.nextToken().charAt(0));
			int b = ctoi(st.nextToken().charAt(0));
			int cap = Integer.parseInt(st.nextToken());

			capacity[a][b] += cap;
			capacity[b][a] += cap;
		}

		bw.write(Maximum_Flow() + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
