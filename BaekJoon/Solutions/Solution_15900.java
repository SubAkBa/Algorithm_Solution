import java.util.*;
import java.io.*;

public class Solution_15900 {

    public static int DFS(List<Integer>[] adj, int current, int prev, int pathCount) {
        boolean isLeaf = true;
        int total = 0;

        for (int node : adj[current]) {
            if (node == prev)
                continue;

            isLeaf = false;
            total += DFS(adj, node, current, pathCount + 1);
        }

        if (isLeaf)
            total += pathCount;

        return total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<Integer>[] adj = new ArrayList[N + 1];

        for (int i = 1; i <= N; ++i)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        int total = DFS(adj, 1, -1, 0);

        bw.write(total % 2 == 0 ? "No" : "Yes");
        bw.flush();
        bw.close();
        br.close();
    }
}
