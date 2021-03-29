import java.io.*;

public class Solution_1769 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] ch = br.readLine().toCharArray();
        int len = ch.length, X = 0;
        for (int i = 0; i < len; ++i)
            X += ch[i] - '0';

        int count = 0;
        if (len > 1)
            ++count;

        while (X / 10 > 0) {
            int Y = 0;

            while (X > 0) {
                Y += X % 10;
                X /= 10;
            }

            X = Y;
            ++count;
        }

        bw.write(count + "\n" + (X % 3 == 0 ? "YES" : "NO"));
        bw.flush();
        bw.close();
        br.close();
    }
}
