import java.util.*;
import java.io.*;

public class Solution_2188 {
	static ArrayList<Integer>[] edgelist;
	static boolean[] matched;
	static int[] node;

	public static boolean Bipartite_Matching(int start) {

		for (int next : edgelist[start]) {
			if (matched[next])
				continue;

			matched[next] = true;

			if (node[next] == 0 || Bipartite_Matching(node[next])) {
				node[next] = start;
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
		matched = new boolean[M + 1];
		node = new int[N + 1];

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
			
			if (Bipartite_Matching(i))
				count++;
		}

		bw.write(count + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
