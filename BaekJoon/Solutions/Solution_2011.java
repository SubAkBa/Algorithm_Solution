import java.util.*;
import java.io.*;

public class Solution_2011 {

    public static boolean isValid(char A, char B) {
        return A == '1' || (A == '2' && B <= '6');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] ch = br.readLine().toCharArray();

        int len = ch.length, MOD = 1000000;
        int[] dp = new int[len];

        if (ch[0] != '0')
            dp[0] = 1;

        for (int i = 1; i < len; ++i) {
            if (ch[i] != '0')
                dp[i] = dp[i - 1];

            if (isValid(ch[i - 1], ch[i])) {
                if (i >= 2)
                    dp[i] += dp[i - 2];
                else
                    ++dp[i];

                dp[i] %= MOD;
            }
        }

        bw.write(dp[len - 1] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
