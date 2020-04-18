import java.util.*;
import java.io.*;

public class Solution_9576 {
	static ArrayList<Integer>[] edgelist;
	static boolean[] matched;
	static int[] node;

	public static boolean ShareBooks(int start) {
		for (int next : edgelist[start]) {
			if (matched[next])
				continue;

			matched[next] = true;

			if (node[next] == 0 || ShareBooks(node[next])) {
				node[next] = start;
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		while ((T--) > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			edgelist = new ArrayList[M + 1];
			matched = new boolean[N + 1];
			node = new int[N + 1];

			for (int i = 1; i <= M; i++) {
				edgelist[i] = new ArrayList<>();
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				for (int j = a; j <= b; j++)
					edgelist[i].add(j);
			}

			int count = 0;
			for (int i = 1; i <= M; i++) {
				Arrays.fill(matched, false);

				if (ShareBooks(i))
					count++;
			}

			bw.write(count + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
