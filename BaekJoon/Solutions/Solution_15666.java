import java.util.*;
import java.io.*;

public class Solution_15666 {
    static int N, M;
    static int[] nums;
    static StringBuilder sb = new StringBuilder();
    static Set<String> table = new HashSet<>();

    public static void combination(int[] list, int idx, int nidx) {
        if (idx == M) {
            StringBuilder temp = new StringBuilder();
            for(int l : list)
                temp.append(l).append(" ");

            if (!table.contains(temp.toString())) {
                table.add(temp.toString());
                sb.append(temp).append("\n");
            }

            return;
        }

        for (int i = nidx; i < N; ++i) {
            list[idx] = nums[i];
            combination(list, idx + 1, i);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        nums = new int[N];
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
