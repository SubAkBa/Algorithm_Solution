import java.util.*;
import java.io.*;

public class Solution_1298 {
	static ArrayList<Integer>[] edgelist;
	static int[] notebook;
	static boolean[] matched;

	public static boolean DFS(int start) {
		for (int next : edgelist[start]) {
			if (matched[next])
				continue;

			matched[next] = true;

			if (notebook[next] == 0 || DFS(notebook[next])) {
				notebook[next] = start;
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

		edgelist = new ArrayList[N + 1];
		matched = new boolean[N + 1];
		notebook = new int[N + 1];

		for (int i = 1; i <= N; i++)
			edgelist[i] = new ArrayList<>();

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			edgelist[a].add(b);
		}

		int count = 0;
		for (int i = 1; i <= N; i++) {
			Arrays.fill(matched, false);

			if (DFS(i))
				count++;
		}

		bw.write(count + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
