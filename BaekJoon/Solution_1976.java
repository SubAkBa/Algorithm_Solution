import java.util.*;
import java.io.*;

public class Solution_1976 {
	static int N, M;
	static int[][] graph;
	static int[] parent, rank;

	public static void Swap(int n1, int n2) {
		int temp = n1;
		n1 = n2;
		n2 = temp;
	}

	public static int Find(int u) {
		if (parent[u] == u)
			return u;

		return parent[u] = Find(parent[u]);
	}

	public static void Union(int u, int v) {
		int uR = Find(u);
		int vR = Find(v);

		if (uR == vR)
			return;

		if (rank[uR] > rank[vR])
			Swap(uR, vR);

		parent[uR] = vR;

		if (rank[uR] == rank[vR])
			rank[vR]++;
	}

	public static void Initialize() {
		for (int i = 1; i <= N; i++)
			parent[i] = i;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		graph = new int[N + 1][N + 1];
		parent = new int[N + 1];
		rank = new int[N + 1];

		Initialize();
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 1; j <= N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				
				if(graph[i][j] == 1)
					Union(i, j);
			}
		}
		

		StringTokenizer st = new StringTokenizer(br.readLine());
		int pre = Integer.parseInt(st.nextToken());
		int cur = Integer.parseInt(st.nextToken());

		while (Find(pre) == Find(cur)) {
			if (st.hasMoreTokens())
				cur = Integer.parseInt(st.nextToken());
			else
				break;
		}

		if (st.hasMoreTokens())
			bw.write("NO");
		else
			bw.write("YES");

		bw.flush();
		bw.close();
		br.close();
	}

}
