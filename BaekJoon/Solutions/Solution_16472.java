import java.util.*;
import java.io.*;

public class Solution_16472 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[] ch = br.readLine().toCharArray();
        int[] count = new int[26];

        int kind = 0;
        int left = 0, right = 0, answer = 0;
        while (right < ch.length) {
            if ((++count[ch[right] - 'a']) == 1)
                ++kind;

            while (left < right && kind > N) {
                if ((--count[ch[left++] - 'a']) == 0)
                    --kind;
            }

            answer = Math.max(answer, right - left + 1);
            ++right;
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
