import java.util.*;
import java.io.*;

public class Solution_15723 {
    static int SIZE = 26;

    public static void Floyd_Warshall(boolean[][] graph) {
        for (int via = 0; via < SIZE; ++via) {
            for (int to = 0; to < SIZE; ++to) {
                for (int from = 0; from < SIZE; ++from) {
                    if (graph[from][via] && graph[via][to])
                        graph[from][to] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[][] graph = new boolean[SIZE][SIZE];

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; ++i) {
            char[] chr = br.readLine().toCharArray();

            graph[chr[0] - 'a'][chr[5] - 'a'] = true;
        }

        Floyd_Warshall(graph);

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; ++i) {
            char[] chr = br.readLine().toCharArray();

            if(graph[chr[0] - 'a'][chr[5] - 'a'])
                bw.write("T\n");
            else
                bw.write("F\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
