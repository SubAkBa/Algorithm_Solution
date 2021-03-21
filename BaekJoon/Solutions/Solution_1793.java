import java.math.BigInteger;
import java.io.*;

public class Solution_1793 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int R = 250;
        BigInteger two = new BigInteger("2");
        BigInteger[] dp = new BigInteger[R + 1];
        dp[0] = dp[1] = BigInteger.ONE;
        dp[2] = new BigInteger("3");

        for (int i = 3; i <= R; ++i)
            dp[i] = dp[i - 1].add(dp[i - 2].multiply(two));

        while (true) {
            String input = br.readLine();

            if (input == null)
                break;

            int n = Integer.parseInt(input);

            bw.write(dp[n] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
