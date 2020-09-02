import java.util.*;
import java.io.*;

public class Solution_4195 {
	static Map<String, Integer> list;
	static int[] parent, rank, relation;
	static int MAX = 100001;

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
		relation[vR] += relation[uR];

		if (rank[uR] == rank[vR])
			rank[vR]++;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testcase = Integer.parseInt(br.readLine());

		for (int i = 0; i < testcase; i++) {
			int F = Integer.parseInt(br.readLine());
			int idx = 0;
			list = new HashMap<>();
			parent = new int[MAX];
			rank = new int[MAX];
			relation = new int[MAX];
			
			Arrays.fill(relation, 1);

			for (int j = 0; j < F; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String name1 = st.nextToken();
				String name2 = st.nextToken();

				if(!list.containsKey(name1)) {
					list.put(name1, idx);
					parent[idx] = idx++;
				}
				
				if(!list.containsKey(name2)) {
					list.put(name2, idx);
					parent[idx] = idx++;
				}

				Union(list.get(name1), list.get(name2));
				
				bw.write(relation[Find(list.get(name1))] + "\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
