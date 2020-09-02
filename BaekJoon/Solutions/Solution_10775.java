import java.util.*;
import java.io.*;

public class Solution_10775 {
	static int[] parent, rank;
	static int G;

	public static void Initialize() {
		for (int i = 1; i <= G; i++)
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
		G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		int count = 0;
		boolean stop = false;

		parent = new int[G + 1];
		rank = new int[G + 1];

		Initialize();

		for (int i = 0; i < P; i++) {
			int g = Integer.parseInt(br.readLine());

			int p = Find(g);

			if (p != 0) {
				Union(p, p - 1);
				count++;
			} else
				break;
		}

		bw.write(count + " ");
		bw.flush();
		bw.close();
		br.close();
	}
}
