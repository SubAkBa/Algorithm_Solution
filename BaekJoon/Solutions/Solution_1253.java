import java.io.*;
import java.util.*;

public class Solution_1253 {

    public static boolean twoPointer(int[] arr, int idx, int N) {
        int left = 0, right = N - 1;

        while (left < right) {
            if (left == idx || arr[left] + arr[right] < arr[idx])
                ++left;
            else if (right == idx || arr[left] + arr[right] > arr[idx])
                --right;
            else
                return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; ++i)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int total = 0;
        for (int i = 0; i < N; ++i) {
            if (twoPointer(arr, i, N))
                ++total;
        }

        bw.write(total + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
