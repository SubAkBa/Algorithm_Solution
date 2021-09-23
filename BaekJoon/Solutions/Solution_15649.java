import java.io.*;
import java.util.*;

public class Solution_15649 {
    static int N, M;

    public static void DFS(int count, List<Integer> list, int visited) {
        if (count == M) {
            for (int l : list)
                System.out.print(l + " ");
            System.out.println();

            return;
        }

        for (int i = 1; i <= N; ++i) {
            if ((visited & (1 << i)) != 0)
                continue;

            visited ^= (1 << i);
            list.add(i);

            DFS(count + 1, list, visited);

            list.remove(list.size() - 1);
            visited ^= (1 << i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        DFS(0, new ArrayList<>(), 0);

        br.close();
    }
}
