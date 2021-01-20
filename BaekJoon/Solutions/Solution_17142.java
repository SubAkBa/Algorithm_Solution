import java.util.*;
import java.io.*;

public class Solution_17142 {
    static int vCount, answer, empty, N, M;
    static boolean[][] checkMap;
    static int[][] map;
    static int[] d = {-1, 0, 1, 0, -1};

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int BFS(List<Point> virus) {
        Queue<Point> queue = new LinkedList<>();
        int time = 0, emptyV = empty;

        for (Point v : virus)
            checkMap[v.x][v.y] = true;
        queue.addAll(virus);

        while (!queue.isEmpty()) {
            int round = queue.size();

            if (emptyV == 0)
                return time;

            ++time;
            while ((--round) >= 0) {
                Point current = queue.poll();

                for (int i = 0; i < 4; ++i) {
                    int nx = current.x + d[i];
                    int ny = current.y + d[i + 1];

                    if (!(0 <= nx && nx < N && 0 <= ny && ny < N))
                        continue;

                    if (map[nx][ny] == 1)
                        continue;

                    if (checkMap[nx][ny])
                        continue;

                    if (map[nx][ny] == 0)
                        --emptyV;

                    queue.offer(new Point(nx, ny));
                    checkMap[nx][ny] = true;
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    public static void DFS(List<Point> virusList, List<Point> virus, int idx, int count) {
        if (count == M) {
            for (int i = 0; i < N; ++i)
                Arrays.fill(checkMap[i], false);

            answer = Math.min(answer, BFS(virus));
            return;
        }

        if(idx == vCount)
            return;

        virus.add(virusList.get(idx));
        DFS(virusList, virus, idx + 1, count + 1);
        virus.remove(virus.size() - 1);
        DFS(virusList, virus, idx + 1, count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        empty = 0;
        map = new int[N][N];
        checkMap = new boolean[N][N];

        List<Point> virusList = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 0)
                    ++empty;
                else if (map[i][j] == 2)
                    virusList.add(new Point(i, j));
            }
        }

        vCount = virusList.size();
        answer = Integer.MAX_VALUE;

        if (empty > 0)
            DFS(virusList, new ArrayList<>(), 0, 0);
        else
            answer = 0;

        bw.write((answer == Integer.MAX_VALUE ? -1 : answer) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
