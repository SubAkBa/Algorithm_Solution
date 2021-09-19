import java.util.*;
import java.io.*;

public class Solution_2109 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);

        for (int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            pq.offer(new int[]{p, d});
        }

        int total = 0;

        boolean[] checked = new boolean[1000001];
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            for (int j = cur[1]; j >= 1; --j) {
                if (!checked[j]) {
                    checked[j] = true;
                    total += cur[0];
                    break;
                }
            }
        }

        bw.write(total + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
