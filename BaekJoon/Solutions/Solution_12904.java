import java.util.*;
import java.io.*;

public class Solution_12904 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();
        StringBuilder T = new StringBuilder(br.readLine());
        int result = 0;

        while (true) {
            System.out.println(S + " " + T);
            if (S.length() == T.length()) {
                if (S.equals(T.toString()))
                    result = 1;
                break;
            }


            if (T.charAt(T.length() - 1) == 'B') {
                T.deleteCharAt(T.length() - 1);
                T.reverse();
            } else{
                T.deleteCharAt(T.length() - 1);
            }

            System.out.println(S + " " + T);
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
