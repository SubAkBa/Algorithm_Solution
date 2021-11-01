import java.util.*;
import java.io.*;

public class Solution_13144 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i)
            arr[i] = Integer.parseInt(st.nextToken());

        Set<Integer> table = new HashSet<>();
        int left = 0, right = 0;
        long total = 0;
        while (right < N) {
            if (!table.contains(arr[right]))
                table.add(arr[right]);
            else {
                while (table.contains(arr[right]))
                    table.remove(arr[left++]);
                table.add(arr[right]);
            }
            total += right - left + 1;

            ++right;
        }

        bw.write(total + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
