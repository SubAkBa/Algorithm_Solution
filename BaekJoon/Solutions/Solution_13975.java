import java.io.*;
import java.util.*;

public class Solution_13975 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while ((--T) >= 0) {
            int K = Integer.parseInt(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            while ((--K) >= 0)
                pq.offer(Long.parseLong(st.nextToken()));

            long total = 0;
            while (pq.size() > 1) {
                long a = pq.poll();
                long b = pq.poll();

                total += a + b;
                pq.offer(a + b);
            }

            bw.write(total + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
