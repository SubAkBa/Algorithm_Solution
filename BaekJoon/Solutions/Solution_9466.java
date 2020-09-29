import java.util.*;
import java.io.*;

public class Solution_9466 {
	static int count;

	public static void DFS(int[] student, int node, int[] visited, boolean[] done) {
		if (done[node] || visited[node] == -1)
			return;

		if (visited[node] == 0)
			visited[node] = 1;
		else if (visited[node] == 1) {
			done[node] = true;
			++count;
		}

		DFS(student, student[node], visited, done);
		visited[node] = -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		while ((--T) >= 0) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			int[] student = new int[n + 1];
			for (int i = 1; i <= n; ++i)
				student[i] = Integer.parseInt(st.nextToken());

			count = 0;
			int[] visited = new int[n + 1]; // 0 : 아직 방문x, 1 : 방문중, -1 : 방문완료
			boolean[] done = new boolean[n + 1];

			for (int i = 1; i <= n; ++i) {
				if (visited[i] == 0)
					DFS(student, student[i], visited, done);
			}

			bw.write((n - count) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}