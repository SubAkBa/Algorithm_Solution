import java.io.*;
import java.util.*;

public class Solution_4796 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = 0;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            if (L == 0 && P == 0 && V == 0)
                break;

            bw.write("Case " + (++n) + ": " + ((V / P) * L + Math.min(V % P, L)) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
