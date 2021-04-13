import java.util.*;
import java.io.*;

public class Solution_1967 {
    static List<Element>[] adj;
    static int[] dist;
    static int n, end_point, diameter;

    public static class Element {
        int idx, d;

        public Element(int idx, int d) {
            this.idx = idx;
            this.d = d;
        }
    }

    public static void DFS(int here, int d) {
        dist[here] = d;

        if (dist[here] > diameter) {
            diameter = dist[here];
            end_point = here;
        }

        for (Element node : adj[here]) {
            if (dist[node.idx] == -1)
                DFS(node.idx, d + node.d);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        diameter = 0;

        adj = new ArrayList[n + 1];
        dist = new int[n + 1];

        for (int i = 0; i <= n; ++i)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; ++i) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[a].add(new Element(b, c));
            adj[b].add(new Element(a, c));
        }

        Arrays.fill(dist, -1);
        DFS(1, 0);

        Arrays.fill(dist, -1);
        DFS(end_point, 0);

        bw.write(diameter + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
