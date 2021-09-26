import java.io.*;
import java.util.*;

public class Solution_15652 {
    static int N, M;

    public static void DFS(int num, int count, List<Integer> list) {
        if (count == M) {
            for (int l : list)
                System.out.print(l + " ");
            System.out.println();
            return;
        }

        for (int i = num; i <= N; ++i) {
            list.add(i);
            DFS(i, count + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        DFS(1, 0, new ArrayList<>());

        br.close();
    }
}
