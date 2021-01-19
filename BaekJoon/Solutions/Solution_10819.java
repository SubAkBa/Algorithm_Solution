import java.util.*;
import java.io.*;

public class Solution_10819 {
    static int answer, N;

    public static void Permutation(int[] nums, List<Integer> permutation, int count, int check) {
        if (count == N) {
            int sum = 0;
            for (int i = 0; i < N - 1; ++i)
                sum += Math.abs(permutation.get(i) - permutation.get(i + 1));

            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < N; ++i) {
            if((check & (1 << i)) != 0)
                continue;

            check ^= (1 << i);
            permutation.add(nums[i]);
            Permutation(nums, permutation, count + 1, check);
            check ^= (1 << i);
            permutation.remove(permutation.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        answer = 0;

        int[] nums = new int[N];
        for (int i = 0; i < N; ++i) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Permutation(nums, new ArrayList<>(), 0, 0);

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
