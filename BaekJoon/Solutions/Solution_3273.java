import java.util.*;
import java.io.*;

public class Solution_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i)
            nums[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nums);

        int x = Integer.parseInt(br.readLine());

        int count = 0;
        int left = 0, right = n - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == x) {
                ++count;
                --right;
            } else if (sum > x)
                --right;
            else
                ++left;
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
