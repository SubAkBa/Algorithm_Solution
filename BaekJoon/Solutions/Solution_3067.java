import java.util.*;
import java.io.*;

public class Solution_3067 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while ((--T) >= 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] coins = new int[N];

            for (int i = 0; i < N; ++i)
                coins[i] = Integer.parseInt(st.nextToken());

            int M = Integer.parseInt(br.readLine());
            int[] counts = new int[M + 1];
            counts[0] = 1;

            for (int i = 0; i < N; ++i) {
                for (int j = coins[i]; j <= M; ++j)
                    counts[j] += counts[j - coins[i]];
            }

            bw.write(counts[M] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
