import java.util.*;
import java.io.*;

public class Solution_20364 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        boolean[] isOccupied = new boolean[N + 1];

        for (int i = 0; i < Q; ++i) {
            int result = 0;
            int input = Integer.parseInt(br.readLine());
            int node = input;

            while (node > 1) {
                if (isOccupied[node])
                    result = node;

                node >>= 1;
            }

            if (result == 0)
                isOccupied[input] = true;

            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
