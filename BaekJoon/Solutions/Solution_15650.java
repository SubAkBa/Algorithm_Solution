import java.io.*;
import java.util.*;

public class Solution_15650 {
    static int N, M;

    public static void DFS(int num, int count, List<Integer> list) {
        if (count == M) {
            for (int l : list)
                System.out.print(l + " ");

            System.out.println();

            return;
        }

        if (num > N)
            return;

        list.add(num);
        DFS(num + 1, count + 1, list);

        list.remove(list.size() - 1);
        DFS(num + 1, count, list);
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
