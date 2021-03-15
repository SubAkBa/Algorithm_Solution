import java.io.*;

public class Solution_14495 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[] fibo = new long[n + 3];
        fibo[1] = fibo[2] = fibo[3] = 1;

        for (int i = 4; i <= n; ++i) {
            fibo[i] = fibo[i - 1] + fibo[i - 3];
        }

        bw.write(fibo[n] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
