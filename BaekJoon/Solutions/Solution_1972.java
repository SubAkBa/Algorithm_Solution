import java.util.*;
import java.io.*;

public class Solution_1972 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String str = br.readLine();

            if (str.equals("*"))
                break;

            boolean flag = true;
            int len = str.length();
            for (int i = 1; i < len && flag; ++i) {
                Set<String> table = new HashSet<>();

                for (int j = 0; j + i < len && flag; ++j) {
                    String temp = String.valueOf(str.charAt(j) + "" + str.charAt(j + i));

                    if (!table.contains(temp))
                        table.add(temp);
                    else {
                        flag = false;
                        break;
                    }
                }
            }

            bw.write(str + " is");
            if (!flag)
                bw.write(" NOT");
            bw.write(" surprising.\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
