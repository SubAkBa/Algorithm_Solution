import java.util.*;
import java.io.*;

public class Solution_11377 {
	static int[] work;
	static boolean[] matched;
	static ArrayList<Integer>[] edgelist;

	public static boolean DFS(int start) {
		for (int next : edgelist[start]) {
			if (matched[next])
				continue;

			matched[next] = true;

			if (work[next] == 0 || DFS(work[next])) {
				work[next] = start;
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		work = new int[M + 1];
		edgelist = new ArrayList[N + 1];
		matched = new boolean[M + 1];
		int[] workcnt = new int[M + 1];

		for (int i = 1; i <= N; i++) {
			edgelist[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());

			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++)
				edgelist[i].add(Integer.parseInt(st.nextToken()));
		}

		int count = 0;

		for (int i = 1; i <= N; i++) {
			Arrays.fill(matched, false);

			if (DFS(i)) {
				count++;
				workcnt[i]++;
			}
		}

		for (int i = 1; i <= N; i++) {
			if (workcnt[i] == 1) {
				Arrays.fill(matched, false);

				if ((K--) > 0 && DFS(i))
					count++;
			}
		}

		bw.write(count + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
