import java.util.*;
import java.io.*;

public class Solution_15565 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] dolls = new int[N];
        for (int i = 0; i < N; ++i)
            dolls[i] = Integer.parseInt(st.nextToken());

        int[] count = new int[3];
        int left = 0, right = 0, answer = Integer.MAX_VALUE;
        while (left < N) {
            while (right < N && count[1] < K)
                ++count[dolls[right++]];

            if (count[1] >= K)
                answer = Math.min(answer, right - left);

            --count[dolls[left++]];
        }

        bw.write((answer == Integer.MAX_VALUE ? -1 : answer) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
