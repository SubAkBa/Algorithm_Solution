import java.util.*;
import java.io.*;

public class Solution_1074 {
    static int round, r, c;

    public static void Divide_Conquer(int N, int row, int col) {
        if (r == row && c == col) {
            System.out.print(round);
            return;
        }

        if (row <= r && r < row + N && col <= c && c < col + N) {
            Divide_Conquer(N / 2, row, col);
            Divide_Conquer(N / 2, row, col + N / 2);
            Divide_Conquer(N / 2, row + N / 2, col);
            Divide_Conquer(N / 2, row + N / 2, col + N / 2);
        } else
            round += N * N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        round = 0;

        Divide_Conquer(1 << N, 0, 0);

        br.close();
    }
}
