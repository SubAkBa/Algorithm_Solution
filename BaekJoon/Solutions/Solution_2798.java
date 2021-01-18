import java.util.*;
import java.io.*;

public class Solution_2798 {
    static int answer, N, M;

    public static void Combination(int[] cards, int idx, int count, int sum) {
        if (count == 3) {
            if(sum <= M)
                answer = Math.max(answer, sum);
            return;
        }

        if (sum >= M || idx == N)
            return;

        Combination(cards,idx + 1, count + 1, sum + cards[idx]);
        Combination(cards,idx + 1, count, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = 0;
        st = new StringTokenizer(br.readLine());
        int[] cards = new int[N];
        for (int i = 0; i < N; ++i)
            cards[i] = Integer.parseInt(st.nextToken());

        Combination(cards, 0, 0, 0);

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
