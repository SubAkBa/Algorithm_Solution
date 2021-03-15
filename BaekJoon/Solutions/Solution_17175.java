import java.io.*;

public class Solution_17175 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int MOD = 1000000007;

        int[] fibo = new int[n + 2];
        fibo[0] = fibo[1] = 1;

        for (int i = 2; i <= n; ++i)
            fibo[i] = (fibo[i - 2] % MOD + fibo[i - 1] % MOD + 1) % MOD;

        bw.write(fibo[n] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
