import java.util.*;
import java.io.*;

public class Solution_1240 {
    public static class Element {
        int idx, dist;

        public Element(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    public static int DFS(List<Element>[] adj, int current, int prev, int end, int dist) {
        if (current == end)
            return dist;

        int result = 0;

        for (Element e : adj[current]) {
            if (e.idx == prev)
                continue;

            result += DFS(adj, e.idx, current, end, dist + e.dist);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Element>[] adj = new ArrayList[N + 1];

        for (int i = 1; i <= N; ++i)
            adj[i] = new ArrayList<>();

        for (int i = 1; i < N; ++i) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            adj[a].add(new Element(b, d));
            adj[b].add(new Element(a, d));
        }

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write(DFS(adj, a, -1, b, 0) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
