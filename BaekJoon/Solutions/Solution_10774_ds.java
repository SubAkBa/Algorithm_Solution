import java.util.*;
import java.io.*;

public class Solution_10774_ds {
	static HashMap<Integer, Character> hm;
	static int[] parent, rank;
	static int J;

	public static void Initialize() {
		for (int i = 1; i <= J; i++)
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

	public static boolean SizeCompare(char size1, char size2) {
		boolean possible = false;
		switch (size1) {
		case 'S':
			possible = true;
			break;
		case 'M':
			if (size2 == 'M' || size2 == 'L')
				possible = true;
			break;
		case 'L':
			if (size2 == 'L')
				possible = true;
			break;
		}

		return possible;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		J = Integer.parseInt(br.readLine());
		int A = Integer.parseInt(br.readLine());
		hm = new HashMap<>();
		parent = new int[J + 1];
		rank = new int[J + 1];

		for (int i = 1; i <= J; i++) {
			char c = br.readLine().charAt(0);
			hm.put(i, c);
		}
		
		Initialize();

		int count = 0;
		for (int i = 0; i < A; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char size = st.nextToken().charAt(0);
			int num = Integer.parseInt(st.nextToken());

			int p = Find(num);
			if (p != 0 && SizeCompare(size, hm.get(num))) {
				count++;
				Union(p, 0);
			}
		}
		
		bw.write(count + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
