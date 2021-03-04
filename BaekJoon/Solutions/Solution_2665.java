import java.util.*;
import java.io.*;

public class Solution_2665 {
    static int INF = 987654321;

    public static class Point implements Comparable<Point> {
        int x, y;
        int blockCount;

        public Point(int x, int y, int blockCount) {
            this.x = x;
            this.y = y;
            this.blockCount = blockCount;
        }

        @Override
        public int compareTo(Point o) {
            return this.blockCount - o.blockCount;
        }
    }

    public static int Dijkstra(int[][] map, int[][] dist, int n) {
        int[] d = new int[]{-1, 0, 1, 0, -1};
        PriorityQueue<Point> pq = new PriorityQueue<>();

        dist[0][0] = 0;
        pq.offer(new Point(0, 0, 0));

        while (!pq.isEmpty()) {
            Point current = pq.poll();

            for (int i = 0; i < 4; ++i) {
                int nx = current.x + d[i];
                int ny = current.y + d[i + 1];
                int count = current.blockCount;

                if (!(0 <= nx && nx < n && 0 <= ny && ny < n))
                    continue;

                if (map[nx][ny] == 0)
                    ++count;

                if (dist[nx][ny] <= count)
                    continue;

                dist[nx][ny] = count;
                pq.offer(new Point(nx, ny, count));
            }
        }

        return dist[n - 1][n - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; ++i) {
            char[] ch = br.readLine().toCharArray();
            Arrays.fill(dist[i], INF);

            for (int j = 0; j < n; ++j)
                map[i][j] = ch[j] - '0';
        }

        bw.write(Dijkstra(map, dist, n) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
