import java.util.*;
import java.io.*;

public class Solution_13549 {
    static int RANGE = 200000, answer;

    public static class Point {
        int pos, time;

        public Point(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }

    public static int BFS(int N, int K) {
        Queue<Point> queue = new LinkedList<>();
        boolean[] visited = new boolean[RANGE + 1];

        visited[N] = true;
        queue.offer(new Point(N, 0));

        while (!queue.isEmpty()) {
            int round = queue.size();

            while ((--round) >= 0) {
                Point current = queue.poll();

                if (current.pos == K) {
                    answer = Math.min(answer, current.time);
                    continue;
                }

                if (answer <= current.time)
                    continue;

                if (current.pos * 2 <= RANGE && !visited[current.pos * 2]) {
                    queue.offer(new Point(current.pos * 2, current.time));
                    visited[current.pos * 2] = true;
                }

                if (current.pos - 1 >= 0 && !visited[current.pos - 1]) {
                    queue.offer(new Point(current.pos - 1, current.time + 1));
                    visited[current.pos - 1] = true;
                }

                if (current.pos + 1 <= RANGE && !visited[current.pos + 1]) {
                    queue.offer(new Point(current.pos + 1, current.time + 1));
                    visited[current.pos + 1] = true;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        answer = Integer.MAX_VALUE;

        bw.write(BFS(N, K) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
