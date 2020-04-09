import java.io.*;
import java.util.*;

public class Solution_1516 {
	static int[] indeg, time, result;
	static int N;
	static ArrayList<Integer>[] edgelist;

	public static void TopologicalSort() {
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (indeg[i] == 0)
				queue.offer(i);
		}

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			for (int next : edgelist[cur]) {
				indeg[next]--;
				result[next] = Math.max(result[next], result[cur] + time[cur]);

				if (indeg[next] == 0)
					queue.offer(next);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());

		indeg = new int[N + 1];
		time = new int[N + 1];
		result = new int[N + 1];
		edgelist = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++)
			edgelist[i] = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			time[i] = t;

			while (st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());

				if (num != -1) {
					edgelist[num].add(i);
					indeg[i]++;
				}
			}
		}

		TopologicalSort();

		for (int i = 1; i <= N; i++)
			bw.write((time[i] + result[i]) + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

}
