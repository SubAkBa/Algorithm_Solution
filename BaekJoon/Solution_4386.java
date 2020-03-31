import java.util.*;
import java.io.*;

public class Solution_4386 {
	static int n;
	static int[] parent, rank;
	static PriorityQueue<Edge> pq;

	public static void Initialize() {
		for (int i = 1; i <= n; i++)
			parent[i] = i;
	}

	public static int Find(int u) {
		if (parent[u] == u)
			return u;

		return parent[u] = Find(parent[u]);
	}

	public static void Swap(int n1, int n2) {
		int temp = n1;
		n1 = n2;
		n2 = temp;
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

	public static double Constellation(int start) {
		double mst = 0;
		int cnt = 0;

		while (!pq.isEmpty() && cnt < n - 1) {
			Edge edge = pq.poll();

			if (Find(edge.to) != Find(edge.from)) {
				mst += edge.cost;
				Union(edge.to, edge.from);
				cnt++;
			}
		}

		return mst;
	}

	public static double getDist(double[] p1, double[] p2) {
		return Math.sqrt((p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]));
	}

	public static class Edge implements Comparable<Edge> {
		int from, to;
		double cost;

		public Edge(int from, int to, double cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		public int compareTo(Edge e) {
			return Double.compare(this.cost, e.cost);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		parent = new int[n + 1];
		rank = new int[n + 1];
		pq = new PriorityQueue<>();
		double[][] star = new double[n + 1][2];

		Initialize();

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());

			star[i][0] = x;
			star[i][1] = y;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = i + 1; j <= n; j++) {
				pq.offer(new Edge(i, j, getDist(star[i], star[j])));
			}
		}

		bw.write(String.format("%.2f", Constellation(1)) + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
