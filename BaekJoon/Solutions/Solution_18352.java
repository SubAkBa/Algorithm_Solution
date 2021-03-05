import java.util.*;
import java.io.*;

public class Solution_18352 {
    static int INF = 987654321;

    public static int[] Dijkstra(List<Integer>[] adj, int X, int[] dist) {
        Queue<Integer> queue = new LinkedList<>();

        dist[X] = 0;
        queue.offer(X);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int to : adj[current]) {
                if (dist[to] <= dist[current] + 1)
                    continue;

                dist[to] = dist[current] + 1;
                queue.offer(to);
            }
        }

        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Integer>[] adj = new ArrayList[N + 1];
        int[] dist = new int[N + 1];

        Arrays.fill(dist, INF);

        for (int i = 1; i <= N; ++i)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            adj[A].add(B);
        }

        Dijkstra(adj, X, dist);

        boolean flag = false;
        for (int i = 1; i <= N; ++i) {
            if (dist[i] == K) {
                flag = true;
                bw.write(i + "\n");
            }
        }

        if (!flag)
            bw.write(-1 + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
