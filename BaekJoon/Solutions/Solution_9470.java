import java.util.*;
import java.io.*;

public class Solution_9470 {

    public static class Element {
        boolean isValid;
        int value, idx;

        public Element(boolean isValid, int value, int idx) {
            this.isValid = isValid;
            this.value = value;
            this.idx = idx;
        }
    }

    public static int topologicalSort(List<Integer>[] adj, int[] indeg, int M, int P) {
        Queue<Integer> queue = new LinkedList<>();
        Element[] strahler = new Element[M + 1];

        for (int i = 1; i <= M; ++i) {
            if (indeg[i] == 0) {
                queue.offer(i);
                strahler[i] = new Element(true, 1, i);
            } else
                strahler[i] = new Element(false, 0, i);
        }

        int seaNode = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            boolean adjSea = true;

            for (int next : adj[cur]) {
                adjSea = false;

                if (strahler[next].value == strahler[cur].value) {
                    strahler[next].isValid = true;
                } else if (strahler[next].value < strahler[cur].value) {
                    strahler[next].value = strahler[cur].value;
                    strahler[next].isValid = false;
                }

                if ((--indeg[next]) == 0) {
                    if (strahler[next].isValid)
                        ++strahler[next].value;

                    queue.offer(next);
                }
            }

            if (adjSea)
                seaNode = cur;
        }

        return strahler[seaNode].value;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while ((--T) >= 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            int[] indeg = new int[M + 1];
            List<Integer>[] adj = new ArrayList[M + 1];

            for (int i = 1; i <= M; ++i)
                adj[i] = new ArrayList<>();

            for (int i = 0; i < P; ++i) {
                st = new StringTokenizer(br.readLine());

                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                ++indeg[B];
                adj[A].add(B);
            }

            bw.write(K + " " + topologicalSort(adj, indeg, M, P) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
