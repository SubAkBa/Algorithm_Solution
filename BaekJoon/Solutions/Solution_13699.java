import java.io.*;

public class Solution_13699 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[] t = new long[n + 3];
        t[0] = t[1] = 1;
        t[2] = 2;

        for (int i = 3; i <= n; ++i) {
            for (int j = 0; j < i; ++j)
                t[i] += t[j] * t[i - j - 1] * 2;

            if ((i & 1) == 1)
                t[i] += t[i / 2] * t[i / 2];
        }

        bw.write(t[n] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
