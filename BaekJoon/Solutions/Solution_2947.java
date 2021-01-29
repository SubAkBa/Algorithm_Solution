import java.util.*;
import java.io.*;

public class Solution_2947 {
    static int LEN = 5;

    public static boolean isFinished(int[] arr) {
        for (int i = 0; i < LEN; ++i) {
            if (arr[i] != (i + 1))
                return false;
        }

        return true;
    }

    public static void Swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void Print(int[] arr) {
        for (int a : arr)
            System.out.print(a + " ");
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[LEN];
        for (int i = 0; i < LEN; ++i)
            arr[i] = Integer.parseInt(st.nextToken());

        while (!isFinished(arr)) {
            for (int i = 0; i < LEN - 1; ++i) {
                if (arr[i] > arr[i + 1]) {
                    Swap(arr, i, i + 1);
                    Print(arr);
                }
            }
        }

        br.close();
    }
}
