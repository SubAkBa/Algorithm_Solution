import java.util.*;
import java.io.*;

public class Solution_13913 {
    static int RANGE = 100000;
    static int[] path;
    static boolean[] visited;

    public static int BFS(int N, int K) {
        Queue<Integer> queue = new LinkedList<>();
        int time = 0;

        path[N] = -1;
        visited[N] = true;
        queue.offer(N);

        while (true) {
            int round = queue.size();

            while ((--round) >= 0) {
                int value = queue.poll();

                if (value == K)
                    return time;

                if (value - 1 >= 0 && !visited[value - 1]) {
                    path[value - 1] = value;
                    queue.offer(value - 1);
                    visited[value - 1] = true;
                }

                if (value - 1 > K)
                    continue;

                if (value + 1 <= RANGE && !visited[value + 1]) {
                    path[value + 1] = value;
                    queue.offer(value + 1);
                    visited[value + 1] = true;
                }

                if (value * 2 <= RANGE && !visited[value * 2]) {
                    path[value * 2] = value;
                    queue.offer(value * 2);
                    visited[value * 2] = true;
                }
            }

            ++time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        path = new int[RANGE + 1];
        visited = new boolean[RANGE + 1];

        if (N >= K) {
            bw.write((N - K) + "\n");
            for (int i = N; i >= K; --i)
                bw.write(i + " ");
        } else {
            int answer = BFS(N, K);
            bw.write(answer + "\n");

            int[] answer_path = new int[answer + 1];
            int idx = answer;
            for (int p = K; p != -1; p = path[p])
                answer_path[idx--] = p;

            for (int i = 0; i <= answer; ++i)
                bw.write(answer_path[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
