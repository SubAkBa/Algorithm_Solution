import java.util.*;
import java.io.*;

public class Solution_9489 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int R = 1000;
        int[] parent = new int[R + 1];

        while (true) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            Arrays.fill(parent, -1);

            if (n == 0 && k == 0)
                break;

            st = new StringTokenizer(br.readLine());

            int num = -1, target = 0, prev = -1;
            for (int i = 1; i <= n; ++i) {
                int node = Integer.parseInt(st.nextToken());

                if (node == k)
                    target = i;

                if (prev + 1 != node)
                    ++num;

                parent[i] = num;
                prev = node;
            }

            int answer = 0;
            for (int i = 1; i <= n; ++i) {
                if (parent[i] != parent[target] && parent[parent[i]] == parent[parent[target]])
                    ++answer;
            }

            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
