import java.util.*;
import java.io.*;

public class Solution_11779 {
    static int INF = 987654321;

    public static class Edge implements Comparable<Edge> {
        int node, weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static void dijkstra(int start, List<Edge>[] adjList, int[] weights, int[] path) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.offer(new Edge(start, 0));
        weights[start] = 0;
        path[start] = start;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            if (current.weight != weights[current.node]) {
                continue;
            }

            for (Edge next : adjList[current.node]) {
                if (weights[next.node] > weights[current.node] + next.weight) {
                    path[next.node] = current.node;
                    weights[next.node] = weights[current.node] + next.weight;
                    pq.offer(new Edge(next.node, weights[next.node]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<Edge>[] adjList = new ArrayList[n + 1];
        int[] weights = new int[n + 1];
        int[] path = new int[n + 1];

        for (int i = 1; i <= n; ++i) {
            adjList[i] = new ArrayList<>();
            weights[i] = INF;
        }

        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adjList[a].add(new Edge(b, c));
        }

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start, adjList, weights, path);

        int count = 1;
        System.out.println(weights[end]);

        List<Integer> answerPath = new ArrayList<>();
        answerPath.add(end);
        for (int i = end; i != start; i = path[i]) {
            ++count;
            answerPath.add(path[i]);
        }
        System.out.println(count);

        for (int i = answerPath.size() - 1; i >= 0; --i) {
            System.out.print(answerPath.get(i) + " ");
        }
    }
}
