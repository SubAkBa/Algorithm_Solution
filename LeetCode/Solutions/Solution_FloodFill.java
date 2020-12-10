
public class Solution_FllodFill {
    static int[] d = {-1, 0, 1, 0, -1};
    static int R, C;

    public boolean isRange(int x, int y) {
        if (0 <= x && x < R && 0 <= y && y < C)
            return true;

        return false;
    }

    public void DFS(int[][] image, int x, int y, int originColor, int newColor) {
        if (!isRange(x, y))
            return;

        if (image[x][y] != originColor || image[x][y] == newColor)
            return;

        image[x][y] = newColor;

        for (int i = 0; i < 4; ++i) {
            int nx = x + d[i];
            int ny = y + d[i + 1];

            DFS(image, nx, ny, originColor, newColor);
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        R = image.length;

        if (R == 0)
            return image;

        C = image[0].length;
        DFS(image, sr, sc, image[sr][sc], newColor);

        return image;
    }
}
