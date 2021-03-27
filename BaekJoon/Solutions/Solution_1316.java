import java.util.*;
import java.io.*;

public class Solution_1316 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < N; ++i) {
            char[] ch = br.readLine().toCharArray();
            Set<Character> table = new HashSet<>();

            boolean flag = true;
            char pre = ch[0];
            for (char c : ch) {
                if (pre != c) {
                    if (table.contains(c)) {
                        flag = false;
                        break;
                    }

                    table.add(pre);
                    pre = c;
                }
            }

            if (flag)
                ++count;
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
