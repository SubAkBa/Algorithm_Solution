import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1068 {
	static int N, count;
	static List<Integer>[] adjList;

	public static void dfs(int node, int del) {
		int child = 0;

		for (int next : adjList[node]) {
			if (next != del) {
				dfs(next, del);
				++child;
			}
		}

		if (child == 0) {
			++count;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		count = 0;
		N = Integer.parseInt(br.readLine());
		adjList = new ArrayList[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; ++i) {
			adjList[i] = new ArrayList<>();
		}

		int root = 0;
		for (int i = 0; i < N; ++i) {
			int a = Integer.parseInt(st.nextToken());

			if (a == -1) {
				root = i;
				continue;
			}

			adjList[a].add(i);
		}

		int del = Integer.parseInt(br.readLine());

		if (del != root) {
			dfs(root, del);
		}

		System.out.println(count);
	}
}