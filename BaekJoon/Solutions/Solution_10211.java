import java.util.*;
import java.io.*;

public class Solution_10211 {

    public static int SubArray(int[] arr, int N) {
        int answer = -1000, sum = -1000;

        for (int i = 0; i < N; ++i) {
            sum = Math.max(sum + arr[i], arr[i]);
            answer = Math.max(sum, answer);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while ((--T) >= 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];

            for (int i = 0; i < N; ++i)
                arr[i] = Integer.parseInt(st.nextToken());

            bw.write(SubArray(arr, N) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
