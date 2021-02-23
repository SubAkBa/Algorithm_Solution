import java.io.*;

public class Solution_2417 {

    public static long Binary_Search(long n) {
        long left = 0, right = n;

        while (left < right) {
            long mid = left + (right - left) / 2;

            if (mid >= Math.sqrt(n))
                right = mid;
            else
                left = mid + 1;
        }

        return right;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());

        bw.write(Binary_Search(n) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
