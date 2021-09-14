import java.io.*;
import java.util.*;

public class Solution_2075 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; ++j) {
                int num = Integer.parseInt(st.nextToken());

                if (pq.size() < N)
                    pq.offer(num);
                else if (pq.peek() < num) {
                    pq.poll();
                    pq.offer(num);
                }
            }
        }

        bw.write(pq.peek() + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
