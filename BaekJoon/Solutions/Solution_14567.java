import java.util.*;
import java.io.*;

public class Solution_14567 {

    public static int[] Topological_Sort(List<Integer>[] adj, int[] indeg, int N) {
        int[] result = new int[N + 1];
        int term = 1;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; ++i) {
            if (indeg[i] == 0)
                queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int depth = queue.size();

            while ((--depth) >= 0) {
                int current = queue.poll();
                result[current] = term;

                for (int next : adj[current]) {
                    if ((--indeg[next]) == 0)
                        queue.offer(next);
                }
            }

            ++term;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] indeg = new int[N + 1];
        List<Integer>[] adj = new ArrayList[N + 1];

        for (int i = 1; i <= N; ++i)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            adj[A].add(B);
            ++indeg[B];
        }

        int[] result = Topological_Sort(adj, indeg, N);
        for (int i = 1; i <= N; ++i)
            bw.write(result[i] + " ");
        bw.flush();
        bw.close();
        br.close();
    }

}
