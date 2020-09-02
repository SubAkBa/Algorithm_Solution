import java.util.*;
import java.io.*;

public class Solution_1325 {
	static ArrayList<Integer>[] edgelist;
	static int N;
	static int[] count;
	static boolean[] visited;

	public static void Hacking(int start) {
		visited[start] = true;

		for (int next : edgelist[start]) {
			if (!visited[next]) {
				count[next]++;
				Hacking(next);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		edgelist = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		count = new int[N + 1];

		for (int i = 1; i <= N; i++)
			edgelist[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			edgelist[A].add(B);
		}

		int max = 0;
		for (int i = 1; i <= N; i++) {
			Arrays.fill(visited, false);
			Hacking(i);
		}

		for (int i = 1; i <= N; i++)
			max = Math.max(max, count[i]);

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (max == count[i])
				sb.append(i + " ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
