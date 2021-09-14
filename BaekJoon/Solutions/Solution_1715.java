import java.io.*;
import java.util.*;

public class Solution_1715 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());

        while ((--N) >= 0)
            pq.offer(Integer.parseInt(br.readLine()));

        int total = 0;
        while (pq.size() >= 1) {
            int n1 = pq.poll();

            if (pq.isEmpty())
                break;

            int n2 = pq.poll();
            total += n1 + n2;
            pq.offer(n1 + n2);
        }

        bw.write(total + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
