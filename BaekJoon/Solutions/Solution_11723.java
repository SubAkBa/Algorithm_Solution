import java.util.*;
import java.io.*;

public class Solution_11723 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        int set = 0, MAX = 21;

        while ((--M) >= 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = st.countTokens();
            String oper = st.nextToken();

            int n = (count == 2) ? Integer.parseInt(st.nextToken()) : 0;

            switch (oper) {
                case "add":
                    set |= (1 << n);
                    break;
                case "remove":
                    set &= ~(1 << n);
                    break;
                case "check":
                    if ((set & (1 << n)) != 0)
                        bw.write(1 + "\n");
                    else
                        bw.write(0 + "\n");
                    break;
                case "toggle":
                    set ^= (1 << n);
                    break;
                case "all":
                    set = ((1 << MAX) - 1);
                    break;
                case "empty":
                    set = 0;
                    break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
