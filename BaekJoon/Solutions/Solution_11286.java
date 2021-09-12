import java.io.*;
import java.util.*;

public class Solution_11286 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> (Math.abs(o1) == Math.abs(o2) ? o1 - o2 : Math.abs(o1) - Math.abs(o2)));
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
