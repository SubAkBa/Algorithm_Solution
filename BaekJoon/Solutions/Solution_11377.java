import java.util.*;
import java.io.*;

public class Solution_11377 {
	static ArrayList<Integer>[] adj;
	static int[] path;
	static boolean[] selected;

	public static boolean Matching(int from) {
		for (int to : adj[from]) {
			if (selected[to])
				continue;

			selected[to] = true;

			if (path[to] == 0 || Matching(path[to])) {
				path[to] = from;
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

		adj = new ArrayList[2 * N + 1];
		path = new int[M + 1];
		selected = new boolean[M + 1];

		for (int i = 1; i <= 2 * N; ++i)
			adj[i] = new ArrayList<>();

		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine());

			int count = Integer.parseInt(st.nextToken());

			for (int j = 0; j < count; ++j) {
				int next = Integer.parseInt(st.nextToken());
				adj[i].add(next);
				adj[N + i].add(next);
			}
		}

		int answer = 0;
		for (int i = 1; i <= N; ++i) {
			Arrays.fill(selected, false);
			if (Matching(i))
				++answer;
		}

		for (int i = N + 1; i <= 2 * N && K > 0; ++i) {
			Arrays.fill(selected, false);
			if (Matching(i)) {
				--K;
				++answer;
			}
		}

		bw.write(answer + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
