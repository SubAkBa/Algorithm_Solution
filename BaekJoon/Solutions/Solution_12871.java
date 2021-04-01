import java.io.*;

public class Solution_12871 {

    public static int GCD(int a, int b) {
        if (a % b == 0)
            return b;

        return GCD(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String t = br.readLine();

        int slen = s.length(), tlen = t.length();
        int n = slen, m = tlen;

        if (n < m) {
            int temp = n;
            n = m;
            m = temp;
        }
        int gcd = GCD(n, m);
        int lcm = slen * tlen / gcd;

        int result = 1;
        for (int i = 0; i < lcm; ++i) {
            if (s.charAt(i % slen) != t.charAt(i % tlen)) {
                result = 0;
                break;
            }
        }


        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
