import java.io.*;

public class Solution_15927 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int len = str.length();

        boolean flag = false;
        int result = -1;
        for (int i = 0; i < len / 2; ++i) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                result = len;
                break;
            } else if (str.charAt(i) != str.charAt(i + 1))
                flag = true;
        }

        if (flag && result == -1)
            result = len - 1;

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
