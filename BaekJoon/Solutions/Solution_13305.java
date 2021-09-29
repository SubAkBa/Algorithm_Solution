import java.io.*;
import java.util.*;

public class Solution_13305 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] dist = new long[N - 1];
        long[] cost = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; ++i)
            dist[i] = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i)
            cost[i] = Long.parseLong(st.nextToken());

        long prev = cost[0];
        long total = cost[0] * dist[0];
        for (int i = 1; i < N - 1; ++i) {
            if (prev > cost[i])
                prev = cost[i];

            total += prev * dist[i];
        }

        bw.write(total + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
