import java.io.*;
import java.math.BigInteger;

public class Solution_10826 {

    public static BigInteger DFS(BigInteger[] sum, int n) {
        if (n <= 0)
            return BigInteger.ZERO;

        if (n == 1)
            return sum[n] = BigInteger.ONE;

        if (sum[n].intValue() != 0)
            return sum[n];

        return sum[n] = DFS(sum, n - 1).add(DFS(sum, n - 2));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        BigInteger[] sum = new BigInteger[n + 1];
        for (int i = 1; i <= n; ++i)
            sum[i] = new BigInteger("0");

        bw.write(DFS(sum, n) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
