import java.io.*;

public class Solution_9655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        bw.write((N % 2 == 0) ? "CY" : "SK");
        bw.flush();
        bw.close();
        br.close();
    }
}
