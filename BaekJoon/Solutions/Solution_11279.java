import java.io.*;
import java.util.*;

public class Solution_11279 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b.compareTo(a));
        int N = Integer.parseInt(br.readLine());

        while ((--N) >= 0) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (pq.size() == 0)
                    bw.write("0\n");
                else
                    bw.write(pq.poll() + "\n");
            } else
                pq.offer(num);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
