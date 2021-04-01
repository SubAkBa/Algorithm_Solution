import java.util.*;
import java.io.*;

public class Solution_5555 {

    public static int[] getPi(String pattern) {
        int len = pattern.length();
        int[] pi = new int[len];

        for (int i = 1, j = 0; i < len; ++i) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j))
                j = pi[j - 1];

            if (pattern.charAt(i) == pattern.charAt(j))
                pi[i] = ++j;
        }

        return pi;
    }

    public static boolean KMP(String str, String pattern, int[] pi) {
        int slen = str.length(), plen = pattern.length();

        for (int i = 0, j = 0; i < slen * 2; ++i) {
            while (j > 0 && str.charAt(i % slen) != pattern.charAt(j))
                j = pi[j - 1];

            if (str.charAt(i % slen) == pattern.charAt(j)) {
                if (j == plen - 1)
                    return true;
                else
                    ++j;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String pattern = br.readLine();
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        int[] pi = getPi(pattern);
        for (int i = 0; i < N; ++i) {
            if (KMP(br.readLine(), pattern, pi))
                ++count;
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
