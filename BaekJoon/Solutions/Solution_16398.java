import java.io.*;
import java.util.*;

public class Solution_16398 {
    static int[] parent, rank;
    static int N;

    public static void init() {
        for (int i = 0; i < N; ++i)
            parent[i] = i;
    }

    public static int find(int u) {
        if (parent[u] == u)
            return u;

        return parent[u] = find(parent[u]);
    }

    public static void union(int u, int v) {
        int uR = find(u);
        int vR = find(v);

        if (uR == vR)
            return;

        if (rank[uR] > rank[vR]) {
            int temp = uR;
            uR = vR;
            vR = temp;
        }

        parent[uR] = vR;

        if (rank[uR] == rank[vR])
            ++rank[vR];
    }

    public static class Edge implements Comparable<Edge> {
        int from, to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static long kruskal(Edge[] edgeList, int M) {
        long total = 0;
        int count = 0;
        Arrays.sort(edgeList);

        for (int i = 0; i < M && count < N - 1; ++i) {
            int fromR = find(edgeList[i].from);
            int toR = find(edgeList[i].to);

            if (fromR == toR)
                continue;

            union(fromR, toR);
            total += edgeList[i].cost;
            ++count;
        }

        return total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        parent = new int[N];
        rank = new int[N];
        int idx = -1, M = ((int) Math.pow(N, 2) - N) / 2;
        Edge[] edgeList = new Edge[M];

        for (int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < i; ++j)
                edgeList[++idx] = new Edge(i, j, Integer.parseInt(st.nextToken()));
        }

        init();

        bw.write(kruskal(edgeList, M) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
