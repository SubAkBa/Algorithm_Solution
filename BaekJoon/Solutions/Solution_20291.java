import java.util.*;
import java.io.*;

public class Solution_20291 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> table = new TreeMap<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; ++i) {
            String ext = br.readLine().split("\\.")[1];
            table.put(ext, table.getOrDefault(ext, 0) + 1);
        }

        for (String key : table.keySet())
            bw.write(key + " " + table.get(key) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
