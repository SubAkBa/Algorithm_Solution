import java.io.*;

public class Solution_1789 {

    public static int Count(long S) {
        long sum = 0;
        int count = 0;

        for (int i = 1; ; ++i) {
            sum += i;
            ++count;

            if (sum + i >= S)
                break;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long S = Long.parseLong(br.readLine());

        bw.write(Count(S) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
