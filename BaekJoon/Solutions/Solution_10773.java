import java.util.*;
import java.io.*;

public class Solution_10773 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int K = Integer.parseInt(br.readLine());

        int sum = 0, idx = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < K; ++i) {
            int num = Integer.parseInt(br.readLine());

            if (num != 0) {
                list.add(num);
                sum += num;
                ++idx;
            } else {
                sum -= list.remove(idx - 1);
                --idx;
            }
        }

        bw.write(sum + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
