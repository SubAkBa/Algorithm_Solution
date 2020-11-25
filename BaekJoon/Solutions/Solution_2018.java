import java.util.*;
import java.io.*;

public class Solution_2018 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int left = 1, right = 2;
        int count = 0;

        int sum = left + right;
        while (right <= N) {
            if (N == sum) {
                ++count;
                sum += (++right);
            } else if (N > sum)
                sum += (++right);
            else
                sum -= (left++);
        }

        bw.write((N == 1 ? 1 : count) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
