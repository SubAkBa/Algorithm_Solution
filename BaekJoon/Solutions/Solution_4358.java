import java.util.*;
import java.io.*;

public class Solution_4358 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        double total = 0;
        TreeMap<String, Integer> table = new TreeMap<>();

        while (true) {
            String tree = br.readLine();

            if (tree.equals(""))
                break;

            ++total;
            table.put(tree, table.getOrDefault(tree, 0) + 1);
        }

        for (String key : table.keySet())
            bw.write(key + " " + String.format("%.4f", (table.get(key) / total * 100)) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
