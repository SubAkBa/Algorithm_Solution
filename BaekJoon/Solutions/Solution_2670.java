import java.io.*;

public class Solution_2670 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        double[] nums = new double[N];

        for (int i = 0; i < N; ++i)
            nums[i] = Double.parseDouble(br.readLine());

        double result = 0, temp = 1;

        for (int i = 0; i < N; ++i) {
            temp = Math.max(temp * nums[i], nums[i]);
            result = Math.max(result, temp);
        }

        bw.write(String.format("%.3f", result) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
