import java.util.*;

public class Solution_MaxAreaofIsland {
    static int[] d = {-1, 0, 1, 0, -1};
    static int m, n;

    public static int BFS(int[][] grid, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        int area = 0;

        queue.offer(new int[]{x, y});
        grid[x][y] = 0;
        ++area;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; ++i) {
                int nx = cur[0] + d[i];
                int ny = cur[1] + d[i + 1];

                if (!(0 <= nx && nx < m && 0 <= ny && ny < n))
                    continue;

                if (grid[nx][ny] == 0)
                    continue;

                queue.offer(new int[]{nx, ny});
                grid[nx][ny] = 0;
                ++area;
            }
        }

        return area;
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0)
                    continue;

                maxArea = Math.max(maxArea, BFS(grid, i, j));
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxAreaOfIsland(new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}})); // 6
        System.out.println(maxAreaOfIsland(new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}})); // 0
    }
}
