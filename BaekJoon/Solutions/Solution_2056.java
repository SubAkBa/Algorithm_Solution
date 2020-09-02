import java.util.*;
import java.io.*;

public class Solution_2056 {
	static int[] indeg, time, result;
	static ArrayList<Integer>[] edgelist;
	static int N;

	public static void Topological_Sort() {
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (indeg[i] == 0)
				queue.offer(i);
		}

		for (int i = 1; i <= N; i++) {
			int cur = queue.poll();

			for (int next : edgelist[cur]) {
				result[next] = Math.max(result[next], result[cur] + time[cur]);

				if ((--indeg[next]) == 0) {
					queue.offer(next);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());

		time = new int[N + 1];
		indeg = new int[N + 1];
		result = new int[N + 1];
		edgelist = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			edgelist[i] = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());

			time[i] = Integer.parseInt(st.nextToken());

			int prework = Integer.parseInt(st.nextToken());

			for (int j = 0; j < prework; j++) {
				indeg[i]++;
				edgelist[Integer.parseInt(st.nextToken())].add(i);
			}
		}

		Topological_Sort();

		int answer = 0;
		for (int i = 1; i <= N; i++)
			answer = Math.max(answer, result[i] + time[i]);

		bw.write(answer + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
