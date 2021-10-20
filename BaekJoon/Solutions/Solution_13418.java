import java.io.*;
import java.util.*;

public class Solution_13418 {
    static int[] parent, rank;
    static int N, M;

    public static void init() {
        for (int i = 0; i <= N; ++i)
            parent[i] = i;

        Arrays.fill(rank, 0);
    }

    public static int find(int u) {
        if (parent[u] == u)
            return u;

        return parent[u] = find(parent[u]);
    }

    public static void union(int u, int v) {
        int uR = find(u);
        int vR = find(v);

        if (rank[uR] > rank[vR]) {
            int temp = uR;
            uR = vR;
            vR = temp;
        }

        parent[uR] = vR;

        if (rank[uR] == rank[vR])
            ++rank[vR];
    }

    public static class Edge {
        int from, to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static long kruskal(Edge[] edgeList) {
        long total = 0;
        int count = 0;

        for (int i = 0; i <= M && count < N; ++i) {
            int fromR = find(edgeList[i].from);
            int toR = find(edgeList[i].to);

            if (fromR == toR)
                continue;

            total += edgeList[i].cost;
            union(fromR, toR);
            ++count;
        }

        return total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        rank = new int[N + 1];

        Edge[] edgeList = new Edge[M + 1];

        for (int i = 0; i <= M; ++i) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edgeList[i] = new Edge(from, to, cost ^ 1);
        }

        init();

        Arrays.sort(edgeList, (a, b) -> (a.cost - b.cost));
        long minValue = kruskal(edgeList);

        init();

        Arrays.sort(edgeList, (a, b) -> (b.cost - a.cost));
        long maxValue = kruskal(edgeList);

        bw.write((maxValue * maxValue) - (minValue * minValue) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
