import java.util.*;
import java.io.*;

public class Solution_9375 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while ((--T) >= 0) {
            int n = Integer.parseInt(br.readLine());

            Map<String, Integer> table = new HashMap<>();
            for (int i = 0; i < n; ++i) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                st.nextToken();
                String type = st.nextToken();

                table.put(type, table.getOrDefault(type, 0) + 1);
            }

            int sum = 1;
            for (String key : table.keySet())
                sum *= (table.get(key) + 1);

            bw.write((sum - 1) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
