import java.util.*;
import java.io.*;

public class Solution_2473 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] result = new long[3];
        long sum = Long.MAX_VALUE;

        long[] nums = new long[N];
        for (int i = 0; i < N; ++i)
            nums[i] = Long.parseLong(st.nextToken());

        Arrays.sort(nums);
        for (int i = 0; i < N; ++i) {
            int left = i + 1, right = N - 1;

            while (left < right) {
                long temp = nums[i] + nums[left] + nums[right];

                if (Math.abs(sum) > Math.abs(temp)) {
                    result[0] = nums[i];
                    result[1] = nums[left];
                    result[2] = nums[right];
                    sum = temp;
                }

                if (temp > 0)
                    --right;
                else
                    ++left;
            }

            if (sum == 0)
                break;
        }

        bw.write(result[0] + " " + result[1] + " " + result[2]);
        bw.flush();
        bw.close();
        br.close();
    }
}