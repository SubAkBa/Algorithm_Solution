import java.util.*;
import java.io.*;

public class Solution_2559 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] sum = new int[N - K + 1];
        int[] temperature = new int[N];
        st = new StringTokenizer(br.readLine());
        int temp = 0;
        for (int i = 0; i < N; ++i) {
            temperature[i] = Integer.parseInt(st.nextToken());
            temp += temperature[i];
            if (i >= (K - 1)) {
                sum[i - K + 1] = temp;
                temp -= temperature[i - K + 1];
            }
        }
        System.out.println("temperature : " + Arrays.toString(temperature));
        System.out.println("sum : " + Arrays.toString(sum));

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < N - K + 1; ++i)
            answer = Math.max(answer, sum[i]);

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
