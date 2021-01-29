import java.util.*;
import java.io.*;

public class Solution_14719 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] block = new int[W];
        for (int i = 0; i < W; ++i)
            block[i] = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();
        int total = 0;

        for (int i = 0; i < W; ++i) {
            while (!stack.isEmpty() && block[i] > block[stack.peek()]) {
                int top = stack.pop();

                if (stack.isEmpty())
                    break;

                int w = i - stack.peek() - 1;
                int h = Math.min(block[i], block[stack.peek()]) - block[top];
                total += w * h;
            }

            stack.push(i);
        }

        bw.write(total + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
