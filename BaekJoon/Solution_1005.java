import java.util.*;
import java.io.*;

public class Solution_1005 {
	static List<Integer>[] adj;
	static int[] D, indeg;
	static int N, K;

	public static int ACM_Craft(int dest) {
		Queue<Integer> queue = new LinkedList<>();
		int[] maxtime = new int[N + 1];

		for (int i = 1; i <= N; ++i) {
			if (indeg[i] == 0) {
				maxtime[i] = D[i];
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			int from = queue.poll();

			for (int to : adj[from]) {
				maxtime[to] = Math.max(maxtime[to], maxtime[from] + D[to]);

				if (--indeg[to] == 0)
					queue.offer(to);
			}
		}

		return maxtime[dest];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		while ((--T) >= 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			D = new int[N + 1];
			indeg = new int[N + 1];
			adj = new ArrayList[N + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; ++i) {
				adj[i] = new ArrayList<>();
				D[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < K; ++i) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());

				adj[X].add(Y);
				++indeg[Y];
			}

			int dest = Integer.parseInt(br.readLine());

			bw.write(ACM_Craft(dest) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
