import java.util.*;
import java.io.*;

public class Solution_1717 {
	static int[] parent, rank;

	public static void Initialize(int n) {
		for (int i = 0; i <= n; i++)
			parent[i] = i;
	}

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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parent = new int[n + 1];
		rank = new int[n + 1];
		
		Initialize(n);

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();			
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			switch(str){
			case "0":
				Union(n1, n2);
				break;
			case "1":
				bw.write(Find(n1) == Find(n2) ? "YES\n" : "NO\n");
				break;
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
