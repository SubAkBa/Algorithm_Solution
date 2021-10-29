import java.io.*;
import java.util.*;

public class Solution_15654 {
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static int[] nums;

    public static void combination(int[] list, int idx, int selected) {
        if (idx == M) {
            for (int l : list)
                sb.append(l).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; ++i) {
            if ((selected & (1 << i)) != 0)
                continue;

            selected ^= (1 << i);
            list[idx] = nums[i];
            combination(list, idx + 1, selected);
            selected ^= (1 << i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i)
            nums[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nums);

        combination(new int[M], 0, 0);

        bw.write(sb.toString() + " ");
        bw.flush();
        bw.close();
        br.close();
    }
}
