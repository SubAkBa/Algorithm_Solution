import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2417 {

    public static long binarySearch(long n) {
        long left = 0, right = Long.MAX_VALUE;

        while (left < right) {
            long mid = left + ((right - left) >>> 1);

            if (mid == 0) {
                if (n <= 0) {
                    right = 0;
                } else {
                    left = 1;
                }

                continue;
            }

            long q = n / mid;

            if (n % mid != 0) {
                ++q;
            }

            if (mid >= q) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        System.out.println(binarySearch(n));
    }
}
