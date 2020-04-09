import java.util.*;
import java.io.*;

public class Solution_1766 {
	static int N;
	static int[] indeg;
	static ArrayList<Integer>[] edgelist;

	public static ArrayList<Integer> TopologicalSort() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		ArrayList<Integer> sortedlist = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			if (indeg[i] == 0)
				pq.offer(i);
		}

		while (!pq.isEmpty()) {
			int cur = pq.poll();

			sortedlist.add(cur);

			for (int next : edgelist[cur]) {
				indeg[next]--;

				if (indeg[next] == 0)
					pq.offer(next);
			}
		}

		return sortedlist;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		indeg = new int[N + 1];
		edgelist = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++)
			edgelist[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			edgelist[A].add(B);

			indeg[B]++;
		}

		for (int num : TopologicalSort())
			bw.write(num + " ");

		bw.flush();
		bw.close();
		br.close();
	}

}
