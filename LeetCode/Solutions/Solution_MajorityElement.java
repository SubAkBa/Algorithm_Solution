import java.util.*;

public class Solution_MajorityElement {

    // O(N) / O(1)
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = Integer.MAX_VALUE;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            count += (candidate == num) ? 1 : -1;
        }

        return candidate;
    }

    // O(N) / O(N)
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int majority = 0, half = (int) Math.floor(nums.length / 2.0);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > half) {
                majority = entry.getKey();
                break;
            }
        }

        return majority;
    }
}
