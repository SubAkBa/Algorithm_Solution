import java.util.*;
import java.io.*;

public class Solution_2150_kosaraju {
	static ArrayList<Integer>[] edgelist, reverse_edgelist;
	static ArrayList<ArrayList<Integer>> scc;
	static ArrayList<Integer> scc_part;
	static boolean[] visited;
	static Stack<Integer> stack;
	static int V, E;

	public static void DFS(int from) {
		visited[from] = true;

		for (int to : edgelist[from]) {
			if (!visited[to])
				DFS(to);
		}

		stack.push(from);
	}

	public static void Reverse_DFS(int from) {
		visited[from] = true;
		scc_part.add(from);

		for (int to : reverse_edgelist[from]) {
			if (!visited[to])
				Reverse_DFS(to);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		edgelist = new ArrayList[V + 1];
		reverse_edgelist = new ArrayList[V + 1];
		visited = new boolean[V + 1];
		stack = new Stack<>();

		for (int i = 1; i <= V; i++) {
			edgelist[i] = new ArrayList<>();
			reverse_edgelist[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			edgelist[A].add(B);
			reverse_edgelist[B].add(A);
		}

		for (int i = 1; i <= V; i++) {
			if (!visited[i])
				DFS(i);
		}

		Arrays.fill(visited, false);
		scc = new ArrayList<>();

		while (!stack.isEmpty()) {
			scc_part = new ArrayList<>();
			int from = stack.pop();

			if (!visited[from]) {
				Reverse_DFS(from);

				if (scc_part.size() > 0) {
					Collections.sort(scc_part);
					scc.add(scc_part);
				}
			}
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
