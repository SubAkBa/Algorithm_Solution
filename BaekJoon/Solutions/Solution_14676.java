import java.util.*;
import java.io.*;

public class Solution_14676 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Integer>[] adj = new ArrayList[N + 1];
        int[] indeg = new int[N + 1];

        for (int i = 1; i <= N; ++i)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());

            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            ++indeg[Y];
            adj[X].add(Y);
        }

        boolean isPos = true;
        int[] count = new int[N + 1];
        for (int i = 0; i < K; ++i) {
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());

            if (type == 2) {
                --count[a];

                if (count[a] == 0) {
                    for (int next : adj[a])
                        ++indeg[next];
                } else if (count[a] == -1) {
                    isPos = false;
                    break;
                }
            } else {
                if (indeg[a] > 0) {
                    isPos = false;
                    break;
                } else {
                    ++count[a];
                    if (count[a] == 1) {
                        for (int next : adj[a])
                            --indeg[next];
                    }
                }
            }
        }

        if (isPos)
            bw.write("King-God-Emperor");
        else
            bw.write("Lier!");

        bw.flush();
        bw.close();
        br.close();
    }
}
