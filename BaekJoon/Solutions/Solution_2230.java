import java.util.*;
import java.io.*;

public class Solution_2230 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        for (int i = 0; i < N; ++i)
            nums[i] = Integer.parseInt(br.readLine());

        Arrays.sort(nums);

        int result = Integer.MAX_VALUE;
        for (int left = 0, right = 1; right < N; ++right) {
            int diff = nums[right] - nums[left];

            if (diff >= M) {
                while (left < right && diff >= M) {
                    result = Math.min(result, diff);
                    ++left;
                    diff = nums[right] - nums[left];
                }
            }
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
