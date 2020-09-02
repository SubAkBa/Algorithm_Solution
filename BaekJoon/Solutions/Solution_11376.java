import java.util.*;
import java.io.*;

public class Solution_11376 {
	static boolean[] matched;
	static ArrayList<Integer>[] edgelist;
	static int[] work;

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

		matched = new boolean[M + 1];
		edgelist = new ArrayList[N + 1];
		work = new int[M + 1];

		for (int i = 1; i <= N; i++) {
			edgelist[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());

			int num = Integer.parseInt(st.nextToken());

			for (int j = 0; j < num; j++)
				edgelist[i].add(Integer.parseInt(st.nextToken()));
		}

		int count = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= 2; j++) {
				Arrays.fill(matched, false);
				if (DFS(i))
					count++;
			}
		}
		

		bw.write(count + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
