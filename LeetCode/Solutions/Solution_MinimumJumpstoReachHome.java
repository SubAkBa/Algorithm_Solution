import java.util.*;

public class Solution_MinimumJumpstoReachHome {
    static int LEN = 6000; // 5997

    public static void Forbidden_Setting(int[] forbidden, Set<Integer> ban) {
        for (int i : forbidden)
            ban.add(i);
    }

    public static boolean isPossible(int[][] visit_N, Set<Integer> ban, int value, int dir, int round) {
        if (ban.contains(value))
            return false;

        if (visit_N[value][dir] != -1 && visit_N[value][dir] <= round)
            return false;

        return true;
    }

    public static class Element {
        int idx, isBackward;

        public Element(int idx, int isBackward) {
            this.idx = idx;
            this.isBackward = isBackward;
        }
    }

    public static int minimumJumps(int[] forbidden, int a, int b, int x) {
        Queue<Element> queue = new LinkedList<>();
        int[][] visit_N = new int[LEN + 1][2];
        Set<Integer> ban = new HashSet<>();
        int round = 0;

        for (int i = 0; i <= LEN; ++i)
            Arrays.fill(visit_N[i], -1);

        Forbidden_Setting(forbidden, ban);
        visit_N[0][0] = 0;
        queue.offer(new Element(0, 0));

        while (!queue.isEmpty()) {
            int depth = queue.size();

            while ((--depth) >= 0) {
                Element current = queue.poll();

                if (current.idx == x)
                    return round;

                int right = current.idx + a;
                if (right <= LEN && isPossible(visit_N, ban, right, 0, round)) {
                    visit_N[right][0] = round;
                    queue.offer(new Element(right, 0));
                }

                if (current.isBackward == 1)
                    continue;

                int left = current.idx - b;
                if (left >= 0 && isPossible(visit_N, ban, left, 1, round)) {
                    visit_N[left][1] = round;
                    queue.offer(new Element(left, 1));
                }
            }

            ++round;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(minimumJumps(new int[]{14, 4, 18, 1, 15}, 3, 15, 9)); // 3
        System.out.println(minimumJumps(new int[]{8, 3, 16, 6, 12, 20}, 15, 13, 11)); // -1
        System.out.println(minimumJumps(new int[]{1, 6, 2, 14, 5, 17, 4}, 16, 9, 7)); // 2
        System.out.println(minimumJumps(new int[]{162, 118, 178, 152, 167, 100, 40, 74, 199, 186,
                26, 73, 200, 127, 30, 124, 193, 84, 184, 36,
                103, 149, 153, 9, 54, 154, 133, 95, 45, 198,
                79, 157, 64, 122, 59, 71, 48, 177, 82, 35,
                14, 176, 16, 108, 111, 6, 168, 31, 134, 164,
                136, 72, 98}, 29, 98, 80)); // 121
        System.out.println(minimumJumps(new int[]{1998}, 1999, 2000, 2000)); // 3998
    }
}
