import java.util.*;
import java.io.*;

public class Solution_9019 {
    static int RANGE = 10000;

    public static class Number {
        int num;
        String order;

        public Number(int num, String order) {
            this.num = num;
            this.order = order;
        }
    }

    public static String BFS(int A, int B) {
        Queue<Number> queue = new LinkedList<>();
        boolean[] visited = new boolean[RANGE];

        queue.offer(new Number(A, ""));
        visited[A] = true;

        while (!queue.isEmpty()) {
            Number current = queue.poll();

            if (current.num == B)
                return current.order;

            // D
            int temp = current.num * 2 % RANGE;
            if (!visited[temp]) {
                queue.offer(new Number(temp, current.order + "D"));
                visited[temp] = true;
            }

            // S
            temp = (current.num == 0 ? RANGE - 1 : current.num - 1);
            if (!visited[temp]) {
                queue.offer(new Number(temp, current.order + "S"));
                visited[temp] = true;
            }

            // L
            temp = current.num % 1000 * 10 + current.num / 1000;
            if (!visited[temp]) {
                queue.offer(new Number(temp, current.order + "L"));
                visited[temp] = true;
            }

            // R
            temp = current.num / 10 + current.num % 10 * 1000;
            if (!visited[temp]) {
                queue.offer(new Number(temp, current.order + "R"));
                visited[temp] = true;
            }
        }

        return "";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while ((--T) >= 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            bw.write(BFS(A, B) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
