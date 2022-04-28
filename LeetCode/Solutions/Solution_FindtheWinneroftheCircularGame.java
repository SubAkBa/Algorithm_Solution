import java.util.*;

public class Solution_FindtheWinneroftheCircularGame {

    public static int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; ++i) {
            queue.offer(i);
        }

        while (queue.size() > 1) {
            int tempK = k;
            while ((--tempK) > 0) {
                queue.offer(queue.poll());
            }

            queue.poll();
        }

        return queue.poll();
    }

    public int recursion(int n, int k) {
        if (n == 1)
            return 1;

        return (recursion(n - 1, k) + k - 1) % n + 1;
    }

    public int findTheWinner(int n, int k) {
        return recursion(n, k);
    }

    public static void main(String[] args) {
        System.out.println(findTheWinner(5, 2)); // 3
        System.out.println(findTheWinner(6, 5)); // 1
    }
}
