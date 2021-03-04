import java.util.*;
import java.io.*;

public class Solution_11779 {
    static int INF = 987654321;

    public static class Node implements Comparable<Node> {
        int idx, cost;

        public Node(int to, int cost) {
            this.idx = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void Dijkstra(List<Node>[] adj, int n, int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        int[] path = new int[n + 1];

        Arrays.fill(dist, INF);

        dist[start] = 0;
        path[start] = -1;
        pq.offer(new Node(start, dist[start]));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.cost > dist[current.idx])
                continue;

            for (Node to : adj[current.idx]) {
                if (dist[to.idx] < dist[current.idx] + to.cost)
                    continue;

                path[to.idx] = current.idx;
                dist[to.idx] = dist[current.idx] + to.cost;
                pq.offer(new Node(to.idx, dist[to.idx]));
            }
        }

        System.out.println(dist[end]);
        List<Integer> paths = new ArrayList<>();

        int p = end;
        while (p != -1) {
            paths.add(p);
            p = path[p];
        }

        int len = paths.size();
        System.out.println(len);
        for (int i = len - 1; i >= 0; --i) {
            System.out.print(paths.get(i) + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<Node>[] adj = new ArrayList[n + 1];

        for (int i = 1; i <= n; ++i)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < m; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[a].add(new Node(b, c));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Dijkstra(adj, n, start, end);

        br.close();
    }
}
