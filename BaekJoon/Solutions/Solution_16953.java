import java.io.*;
import java.util.*;

public class Solution_16953 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int count = 1;
        while (A < B) {
            if (B % 10 == 1)
                B /= 10;
            else if (B % 2 == 0)
                B /= 2;
            else
                break;

            ++count;
        }

        if (A == B)
            bw.write(count + "");
        else
            bw.write("-1");

        bw.flush();
        bw.close();
        br.close();
    }
}
