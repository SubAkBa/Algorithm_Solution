import java.util.*;
import java.io.*;

public class Solution_17141 {
    static int time = Integer.MAX_VALUE, N, M, blank;
    static int[] d = new int[]{-1, 0, 1, 0, -1};

    public static int Spread(int[][] cp_map, List<int[]> select) {
        Queue<int[]> queue = new LinkedList<>();
        int round = 0;
        int temp_blank = blank;

        for (int[] pos : select) {
            --temp_blank;
            cp_map[pos[0]][pos[1]] = 1;
            queue.offer(pos);
        }

        if (temp_blank == 0)
            return 0;

        while (!queue.isEmpty()) {
            int depth = queue.size();

            ++round;

            while ((--depth) >= 0) {
                int[] current = queue.poll();

                for (int i = 0; i < 4; ++i) {
                    int nx = current[0] + d[i];
                    int ny = current[1] + d[i + 1];

                    if (!(0 <= nx && nx < N && 0 <= ny && ny < N))
                        continue;

                    if (cp_map[nx][ny] == 1)
                        continue;

                    if (cp_map[nx][ny] == 0 || cp_map[nx][ny] == 2)
                        --temp_blank;

                    cp_map[nx][ny] = 1;
                    queue.offer(new int[]{nx, ny});
                }

            }

            if (temp_blank == 0)
                return round;

        }


        return Integer.MAX_VALUE;
    }

    public static void Choice(int[][] map, List<int[]> cand_point, int idx, List<int[]> select) {
        if (select.size() == M) {
            time = Math.min(time, Spread(CopyMap(map), select));
            return;
        }

        if (idx == cand_point.size())
            return;

        select.add(cand_point.get(idx));
        Choice(map, cand_point, idx + 1, select);

        select.remove(select.size() - 1);
        Choice(map, cand_point, idx + 1, select);
    }

    public static int[][] CopyMap(int[][] map) {
        int[][] cp_map = new int[N][N];

        for (int i = 0; i < N; ++i)
            System.arraycopy(map[i], 0, cp_map[i], 0, N);

        return cp_map;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<int[]> cand_point = new ArrayList<>();
        blank = 0;
        int[][] map = new int[N][N];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2)
                    cand_point.add(new int[]{i, j});

                if (map[i][j] != 1)
                    ++blank;
            }
        }

        if (blank > 0)
            Choice(map, cand_point, 0, new ArrayList<>());

        bw.write((time == Integer.MAX_VALUE ? -1 : time) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}