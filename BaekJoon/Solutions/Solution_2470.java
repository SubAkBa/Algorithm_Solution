import java.util.*;
import java.io.*;

public class Solution_2470 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];

        for (int i = 0; i < N; ++i)
            nums[i] = Integer.parseInt(st.nextToken());

        int[] result = new int[2];
        int sum = Integer.MAX_VALUE;
        int left = 0, right = N - 1;

        Arrays.sort(nums);

        while (left < right) {
            int temp_sum = nums[left] + nums[right];

            if (Math.abs(sum) > Math.abs(temp_sum)) {
                result[0] = nums[left];
                result[1] = nums[right];
                sum = temp_sum;
            }

            if (temp_sum > 0)
                --right;
            else
                ++left;
        }

        bw.write(result[0] + " " + result[1]);
        bw.flush();
        bw.close();
        br.close();
    }
}
