import java.io.*;
import java.util.*;

public class Solution_3649 {

    public static int[] twoPointer(int[] block, int x, int n) {
        if (n < 2)
            return new int[]{0, 0};

        int left = 0, right = n - 1;

        while (left < right) {
            if (block[left] + block[right] > x)
                --right;
            else if (block[left] + block[right] < x)
                ++left;
            else
                break;
        }

        return new int[]{left, right};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String xStr = br.readLine();

            if (xStr.equals(""))
                break;

            int x = Integer.parseInt(xStr) * 10000000;
            int n = Integer.parseInt(br.readLine());

            int[] block = new int[n];
            for (int i = 0; i < n; ++i)
                block[i] = Integer.parseInt(br.readLine());

            Arrays.sort(block);

            int[] answer = twoPointer(block, x, n);

            if (answer[0] == answer[1] || block[answer[0]] + block[answer[1]] != x)
                bw.write("danger\n");
            else
                bw.write("yes " + block[answer[0]] + " " + block[answer[1]] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
