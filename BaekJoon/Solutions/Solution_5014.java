import java.util.*;
import java.io.*;

public class Solution_5014 {

	public static String BFS(int F, int S, int G, int U, int D) {
		Queue<Integer> queue = new LinkedList<>();

		boolean[] visited = new boolean[F + 1];
		int step = 0;

		visited[S] = true;
		queue.offer(S);

		while (!queue.isEmpty()) {
			int round = queue.size();

			while ((--round) >= 0) {
				int floor = queue.poll();

				if (floor == G)
					return Integer.toString(step);

				if (floor + U <= F && !visited[floor + U]) {
					visited[floor + U] = true;
					queue.offer(floor + U);
				}

				if (floor - D >= 1 && !visited[floor - D]) {
					visited[floor - D] = true;
					queue.offer(floor - D);
				}
			}

			++step;
		}

		return "use the stairs";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		bw.write(BFS(F, S, G, U, D) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
