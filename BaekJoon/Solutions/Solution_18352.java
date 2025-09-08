import java.util.*;
import java.io.*;

public class Solution_18352 {
    public static void function(int X, List<Integer>[] adjList, int[] dist) {
        Queue<Integer> pq = new LinkedList<>();

        pq.offer(X);
        dist[X] = 0;

        while (!pq.isEmpty()) {
            int current = pq.poll();

            for (int next : adjList[current]) {
                if (dist[next] > dist[current] + 1) {
                    dist[next] = dist[current] + 1;
                    pq.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int INF = 987654321;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Integer>[] adjList = new ArrayList[N + 1];
        int[] dist = new int[N + 1];

        for (int i = 1; i <= N; ++i) {
            adjList[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            adjList[A].add(B);
        }

        function(X, adjList, dist);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; ++i) {
            if (dist[i] == K) {
                sb.append(i).append("\n");
            }
        }

        if (sb.length() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }
}
