import java.io.*;
import java.util.StringTokenizer;

public class Solution_2502 {

    public static int Fibonacci(int[] fibo, int n) {
        if (n <= 0)
            return 0;

        if (n == 1)
            return fibo[n] = 1;

        if (fibo[n] != 0)
            return fibo[n];

        return fibo[n] = Fibonacci(fibo, n - 1) + Fibonacci(fibo, n - 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] fibo = new int[D + 1];
        Fibonacci(fibo, D);

        int a_ratio = fibo[D - 2];
        int b_ratio = fibo[D - 1];

        for (int i = 1; ; ++i) {
            int a = i;

            if ((K - a * a_ratio) % b_ratio != 0)
                continue;

            bw.write(a + "\n" + ((K - a * a_ratio) / b_ratio));
            break;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
