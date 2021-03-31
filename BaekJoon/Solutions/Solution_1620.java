import java.util.*;
import java.io.*;

public class Solution_1620 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> name2num = new HashMap<>();
        Map<Integer, String> num2name = new HashMap<>();

        for (int i = 1; i <= N; ++i) {
            String name = br.readLine();

            name2num.put(name, i);
            num2name.put(i, name);
        }

        for (int i = 0; i < M; ++i) {
            String q = br.readLine();

            if (Character.isAlphabetic(q.charAt(0)))
                bw.write(name2num.get(q) + "\n");
            else
                bw.write(num2name.get(Integer.parseInt(q)) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
