import java.util.*;
import java.io.*;

public class Solution_6086 {
	static int[][] capacity, flow;
	static int LEN = 52;

	public static int NetworkFlow(int source, int sink) {
		int totalflow = 0;

		for (int i = 0; i < LEN; i++)
			Arrays.fill(flow[i], 0);

		while (true) {
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.offer(source);

			int[] parent = new int[LEN];
			Arrays.fill(parent, -1);
			parent[source] = source;

			while (!queue.isEmpty() && parent[sink] == -1) {
				int from = queue.poll();

				for (int to = 0; to < LEN; to++) {
					if (capacity[from][to] - flow[from][to] > 0 && parent[to] == -1) {
						parent[to] = from;
						queue.offer(to);
					}
				}
			}

			if (parent[sink] == -1)
				break;

			int amount = Integer.MAX_VALUE;

			for (int p = sink; p != source; p = parent[p])
				amount = Math.min(capacity[parent[p]][p] - flow[parent[p]][p], amount);

			for (int p = sink; p != source; p = parent[p]) {
				flow[parent[p]][p] += amount;
				flow[p][parent[p]] -= amount;
			}

			totalflow += amount;
		}

		return totalflow;
	}

	public static int ctoi(char c) {
		if (c - 'Z' <= 0)
			return c - 'A';

		return c - 'a' + 26;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		capacity = new int[LEN][LEN];
		flow = new int[LEN][LEN];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int from = ctoi(st.nextToken().charAt(0));
			int to = ctoi(st.nextToken().charAt(0));
			int cap = Integer.parseInt(st.nextToken());
			
			capacity[from][to] += cap;
			capacity[to][from] += cap;
		}

		bw.write(NetworkFlow(ctoi('A'), ctoi('Z')) + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
