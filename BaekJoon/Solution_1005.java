import java.util.*;
import java.io.*;

public class Solution_1005 {
	static ArrayList<Integer>[] edgelist;
	static int[] indeg, time, acc_time;
	static int N;

	public static int Build(int target) {
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (indeg[i] == 0) {
				acc_time[i] = time[i];
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			int from = queue.poll();

			for (int to : edgelist[from]) {
				indeg[to]--;

				if (indeg[to] == 0)
					queue.offer(to);

				acc_time[to] = Math.max(acc_time[to], acc_time[from] + time[to]);
			}
		}

		return acc_time[target];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		while ((T--) > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());

			time = new int[N + 1];
			indeg = new int[N + 1];
			edgelist = new ArrayList[N + 1];
			acc_time = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
				edgelist[i] = new ArrayList<>();
			}

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());

				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());

				edgelist[X].add(Y);
				indeg[Y]++;
			}

			int target = Integer.parseInt(br.readLine());

			bw.write(Build(target) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
