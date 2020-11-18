import java.util.*;

public class Solution_FindKPairswithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0] + a[1], b[0] + b[1]));
        List<List<Integer>> answer = new ArrayList<>();

        int len1 = nums1.length, len2 = nums2.length;

        if (len1 == 0 || len2 == 0)
            return answer;

        for (int i = 0; i < len1; ++i)
            pq.offer(new int[]{nums1[i], nums2[0], 0});

        while ((--k) >= 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();

            List<Integer> list = new ArrayList<>();
            list.add(cur[0]);
            list.add(cur[1]);
            answer.add(list);

            if (cur[2] == len2 - 1)
                continue;

            pq.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }

        return answer;
    }
}
