import java.util.*;
import java.io.*;

public class Solution_7785 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        NavigableSet<String> table = new TreeSet<>();

        for (int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();

            if (status.equals("enter"))
                table.add(name);
            else
                table.remove(name);
        }

        Iterator<String> iter = table.descendingIterator();

        while (iter.hasNext())
            bw.write(iter.next() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
