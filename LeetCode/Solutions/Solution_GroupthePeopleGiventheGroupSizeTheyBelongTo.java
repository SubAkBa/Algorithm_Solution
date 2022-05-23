import java.util.*;

public class Solution_GroupthePeopleGiventheGroupSizeTheyBelongTo {

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        int size = groupSizes.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < size; ++i) {
            map.putIfAbsent(groupSizes[i], new ArrayList<>());
            map.get(groupSizes[i]).add(i);
        }

        for (int key : map.keySet()) {
            int bLen = map.get(key).size();
            for (int j = 0; j < bLen; j += key) {
                answer.add(map.get(key).subList(j, j + key));
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3})); // [[5],[0,1,2],[3,4,6]]
        System.out.println(groupThePeople(new int[]{2, 1, 3, 3, 3, 2})); // [[1],[0,5],[2,3,4]]
    }
}
