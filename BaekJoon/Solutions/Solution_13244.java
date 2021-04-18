import java.util.*;
import java.io.*;

public class Solution_13244 {
    static List<Integer>[] adj;
    static boolean[] visited;
    static int N;

    public static void DFS(int here) {
        visited[here] = true;

        for (int next : adj[here]) {
            if (!visited[next])
                DFS(next);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        String answer = null;

        while ((--T) >= 0) {
            N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            adj = new ArrayList[N + 1];
            visited = new boolean[N + 1];
            answer = "tree";

            for (int i = 1; i <= N; ++i)
                adj[i] = new ArrayList<>();

            for (int i = 0; i < M; ++i) {
                st = new StringTokenizer(br.readLine());

                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                adj[A].add(B);
                adj[B].add(A);
            }

            if (M != N - 1)
                answer = "graph";
            else {
                DFS(1);

                for (int i = 1; i <= N; ++i) {
                    if (!visited[i]) {
                        answer = "graph";
                        break;
                    }
                }
            }

            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}