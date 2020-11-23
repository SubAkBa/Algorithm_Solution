import java.util.*;
import java.io.*;

public class Solution_1939 {

    public static boolean BFS(int N, List<Bridge>[] adj, int start, int end, int weight) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int from = queue.poll();

            if (from == end)
                return true;

            for (Bridge to : adj[from]) {
                if (visited[to.idx])
                    continue;

                if (to.weight < weight)
                    continue;

                visited[to.idx] = true;
                queue.offer(to.idx);
            }
        }

        return false;
    }

    public static class Bridge {
        int idx, weight;

        public Bridge(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Bridge>[] adj = new ArrayList[N + 1];
        int[] weights = new int[M];

        for (int i = 0; i <= N; ++i)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            adj[A].add(new Bridge(B, C));
            adj[B].add(new Bridge(A, C));

            weights[i] = C;
        }

        Arrays.sort(weights);

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int left = 0, right = M - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (BFS(N, adj, start, end, weights[mid]))
                left = mid + 1;
            else
                right = mid - 1;
        }

        bw.write(weights[right] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}