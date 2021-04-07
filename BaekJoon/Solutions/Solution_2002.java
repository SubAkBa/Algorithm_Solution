import java.util.*;
import java.io.*;

public class Solution_2002 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; ++i) {
            String car = br.readLine();

            map.put(car, i + 1);
        }

        int[] out = new int[N];
        for (int i = 0; i < N; ++i) {
            out[i] = map.get(br.readLine());
        }

        int count = 0;
        for (int i = 0; i < N - 1; ++i) {
            for (int j = i + 1; j < N; ++j) {
                if (out[i] > out[j]) {
                    ++count;
                    break;
                }
            }
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
