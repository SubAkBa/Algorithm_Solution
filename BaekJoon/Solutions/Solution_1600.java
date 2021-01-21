import java.util.*;
import java.io.*;

public class Solution_1600 {
    static int W, H, K;
    static int[][] map;
    static int[] d = {-1, 0, 1, 0, -1};
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1}, dy = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static class Point {
        int x, y, k;

        public Point(int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
        }
    }

    public static int BFS() {
        boolean[][][] visited = new boolean[K + 1][H][W];
        Queue<Point> queue = new LinkedList<>();

        map[0][0] = 0;
        visited[K][0][0] = true;
        queue.offer(new Point(0, 0, K));

        while (!queue.isEmpty()) {
            int round = queue.size();

            while ((--round) >= 0) {
                Point current = queue.poll();

                if(current.x == H - 1 && current.y == W - 1)
                    return map[H - 1][W - 1];

                if (current.k > 0) {
                    for (int i = 0; i < 8; ++i) {
                        int nx = current.x + dx[i];
                        int ny = current.y + dy[i];

                        if (!(0 <= nx && nx < H && 0 <= ny && ny < W))
                            continue;

                        if (map[nx][ny] == 1)
                            continue;

                        if (visited[current.k - 1][nx][ny])
                            continue;

                        visited[current.k - 1][nx][ny] = true;
                        map[nx][ny] = map[current.x][current.y] + 1;
                        queue.offer(new Point(nx, ny, current.k - 1));
                    }
                }

                for (int i = 0; i < 4; ++i) {
                    int nx = current.x + d[i];
                    int ny = current.y + d[i + 1];

                    if (!(0 <= nx && nx < H && 0 <= ny && ny < W))
                        continue;

                    if (map[nx][ny] == 1)
                        continue;

                    if (visited[current.k][nx][ny])
                        continue;

                    visited[current.k][nx][ny] = true;
                    map[nx][ny] = map[current.x][current.y] + 1;
                    queue.offer(new Point(nx, ny, current.k));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];

        for (int i = 0; i < H; ++i) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < W; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(BFS() + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
