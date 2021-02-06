import java.io.*;

public class Solution_2023 {

    public static boolean isPrime(int num) {
        if (num == 1)
            return false;

        if (num == 2)
            return true;

        if (num % 2 == 0)
            return false;

        int sqrt_n = (int) Math.sqrt(num);
        for (int i = 3; i <= sqrt_n; i += 2) {
            if (num % i == 0)
                return false;
        }

        return true;
    }

    public static void DFS(int N, int len, int num) {
        if (!isPrime(num))
            return;

        if (len == N) {
            System.out.println(num);
            return;
        }

        for (int i = 1; i < 10; ++i) {
            DFS(N, len + 1, num * 10 + i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i < 10; ++i)
            DFS(N, 1, i);

        br.close();
    }
}
