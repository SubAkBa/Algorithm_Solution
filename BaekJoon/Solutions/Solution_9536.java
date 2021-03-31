import java.util.*;
import java.io.*;

public class Solution_9536 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while ((--T) >= 0) {
            String[] input = br.readLine().split(" ");
            int len = input.length;
            boolean[] notFox = new boolean[len];

            while (true) {
                String[] split = br.readLine().split(" ");

                if (split[0].equals("what"))
                    break;

                for (int i = 0; i < len; ++i) {
                    if (input[i].equals(split[2]))
                        notFox[i] = true;
                }
            }

            for (int i = 0; i < len; ++i) {
                if (!notFox[i])
                    bw.write(input[i] + " ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
