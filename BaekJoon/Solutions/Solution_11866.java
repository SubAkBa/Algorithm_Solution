import java.util.*;
import java.io.*;

public class Solution_11866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= N; ++i)
            list.add(i);

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int step = 0;
        while (!list.isEmpty()) {
            step = (K + step - 1) % list.size();

            if(list.size() == 1)
                sb.append(list.remove(step));
            else
                sb.append(list.remove(step) + ", ");
        }

        sb.append(">");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
