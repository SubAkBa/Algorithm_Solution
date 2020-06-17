import java.util.*;
import java.io.*;

public class Solution_2150_tarjan {
	static int V, E, id = 0;
	static int[] dfsn;
	static boolean[] finished;
	static Stack<Integer> stack;
	static ArrayList<ArrayList<Integer>> scc;
	static ArrayList<Integer>[] edgelist;

	public static int DFS(int from) {
		dfsn[from] = ++id;
		stack.push(from);

		int result = dfsn[from];
		for (int to : edgelist[from]) {
			if (dfsn[to] == 0)
				result = Math.min(result, DFS(to));
			else if (!finished[to])
				result = Math.min(result, dfsn[to]);
		}

		if (result == dfsn[from]) {
			ArrayList<Integer> part = new ArrayList<>();

			while (true) {
				int to = stack.pop();
				
				part.add(to);
				finished[to] = true;

				if (to == from)
					break;
			}

			Collections.sort(part);
			scc.add(part);
		}

		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		scc = new ArrayList<>();
		stack = new Stack<>();
		dfsn = new int[V + 1];
		finished = new boolean[V + 1];
		edgelist = new ArrayList[V + 1];

		for (int i = 1; i <= V; i++)
			edgelist[i] = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			edgelist[A].add(B);
		}

		for (int i = 1; i <= V; i++) {
			if (dfsn[i] == 0)
				DFS(i);
		}

		Collections.sort(scc, new Comparator<ArrayList<Integer>>() {
			public int compare(ArrayList<Integer> a1, ArrayList<Integer> a2) {
				return a1.get(0) - a2.get(0);
			}
		});

		bw.write(scc.size() + "\n");
		for (ArrayList<Integer> num : scc) {
			for (int n : num)
				bw.write(n + " ");
			bw.write("-1\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
