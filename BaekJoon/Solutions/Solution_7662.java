import java.util.*;
import java.io.*;

public class Solution_7662 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while ((--T) >= 0) {
            int k = Integer.parseInt(br.readLine());

            boolean[] valid = new boolean[1000001];
            PriorityQueue<int[]> maxPq = new PriorityQueue<>((a, b) -> (a[0] <= b[0] ? 1 : -1));
            PriorityQueue<int[]> minPq = new PriorityQueue<>((a, b) -> (a[0] > b[0]) ? 1 : -1);

            while ((--k) >= 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                char c = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());

                if (c == 'I') {
                    maxPq.offer(new int[]{n, k});
                    minPq.offer(new int[]{n, k});
                    valid[k] = true;
                } else {
                    if (n == -1) {
                        while (!minPq.isEmpty() && !valid[minPq.peek()[1]])
                            minPq.poll();

                        if (!minPq.isEmpty())
                            valid[minPq.poll()[1]] = false;
                    } else {
                        while (!maxPq.isEmpty() && !valid[maxPq.peek()[1]])
                            maxPq.poll();

                        if (!maxPq.isEmpty())
                            valid[maxPq.poll()[1]] = false;
                    }
                }
            }

            while (!minPq.isEmpty() && !valid[minPq.peek()[1]])
                minPq.poll();

            while (!maxPq.isEmpty() && !valid[maxPq.peek()[1]])
                maxPq.poll();

            bw.write(maxPq.isEmpty() || minPq.isEmpty() ? "EMPTY\n" : (maxPq.poll()[0] + " " + minPq.poll()[0] + "\n"));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
