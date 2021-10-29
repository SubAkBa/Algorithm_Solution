import java.util.*;
import java.io.*;

public class Solution_15970 {

    public static int leftDist(int idx, List<Integer> list) {
        if (idx == 0)
            return Integer.MAX_VALUE;

        return list.get(idx) - list.get(idx - 1);
    }

    public static int rightDist(int idx, List<Integer> list) {
        if (idx == list.size() - 1)
            return Integer.MAX_VALUE;

        return list.get(idx + 1) - list.get(idx);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Integer>[] p = new ArrayList[N + 1];
        StringTokenizer st = null;

        for (int i = 1; i <= N; ++i)
            p[i] = new ArrayList<>();

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());

            p[color].add(idx);
        }

        for (int i = 1; i <= N; ++i)
            Collections.sort(p[i]);

        int total = 0;
        for (int i = 1; i <= N; ++i) {
            if (p[i].size() == 1)
                continue;

            for (int j = 0; j < p[i].size(); ++j) {
                int left = leftDist(j, p[i]);
                int right = rightDist(j, p[i]);

                total += Math.min(left, right);
            }
        }

        bw.write(total + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
