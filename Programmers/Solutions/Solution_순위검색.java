import java.util.*;

public class Solution_순위검색 {

    public static int Lower_Bound(List<Integer> list, int score, boolean flag) {
        int left = 0, right = list.size() - 1;

        if (flag) {
            if (list.get(right) <= score)
                return right + 1;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (score <= list.get(mid))
                right = mid;
            else
                left = mid + 1;
        }

        return right;
    }

    public static void addScore(List[][][][] list, int score, int a, int b, int c, int d) {
        list[a][b][c][d].add(Lower_Bound(list[a][b][c][d], score, true), score);
        list[0][b][c][d].add(Lower_Bound(list[0][b][c][d], score, true), score);
        list[a][0][c][d].add(Lower_Bound(list[a][0][c][d], score, true), score);
        list[a][b][0][d].add(Lower_Bound(list[a][b][0][d], score, true), score);
        list[a][b][c][0].add(Lower_Bound(list[a][b][c][0], score, true), score);

        list[0][0][c][d].add(Lower_Bound(list[0][0][c][d], score, true), score);
        list[0][b][0][d].add(Lower_Bound(list[0][b][0][d], score, true), score);
        list[0][b][c][0].add(Lower_Bound(list[0][b][c][0], score, true), score);
        list[a][0][0][d].add(Lower_Bound(list[a][0][0][d], score, true), score);
        list[a][0][c][0].add(Lower_Bound(list[a][0][c][0], score, true), score);
        list[a][b][0][0].add(Lower_Bound(list[a][b][0][0], score, true), score);

        list[0][0][0][d].add(Lower_Bound(list[0][0][0][d], score, true), score);
        list[0][0][c][0].add(Lower_Bound(list[0][0][c][0], score, true), score);
        list[0][b][0][0].add(Lower_Bound(list[0][b][0][0], score, true), score);
        list[a][0][0][0].add(Lower_Bound(list[a][0][0][0], score, true), score);

        list[0][0][0][0].add(Lower_Bound(list[0][0][0][0], score, true), score);
    }

    public static int[] solution(String[] info, String[] query) {
        String[][] str = {{"cpp", "java", "python"}, {"backend", "frontend"}, {"junior", "senior"}, {"chicken", "pizza"}};
        List[][][][] list = new ArrayList[4][3][3][3];
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 3; ++j) {
                for (int p = 0; p < 3; ++p) {
                    for (int q = 0; q < 3; ++q) {
                        list[i][j][p][q] = new ArrayList<Integer>();
                        list[i][j][p][q].add(0);
                    }
                }
            }
        }

        map.put("-", 0);
        for (String[] s : str) {
            for (int i = 0; i < s.length; ++i)
                map.put(s[i], i + 1);
        }

        for (String s : info) {
            StringTokenizer st = new StringTokenizer(s);

            int a = map.get(st.nextToken());
            int b = map.get(st.nextToken());
            int c = map.get(st.nextToken());
            int d = map.get(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            addScore(list, score, a, b, c, d);
        }

        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; ++i) {
            String[] qinfo = query[i].split(" ");

            int a = map.get(qinfo[0]);
            int b = map.get(qinfo[2]);
            int c = map.get(qinfo[4]);
            int d = map.get(qinfo[6]);
            int score = Integer.parseInt(qinfo[7]);

            int count = Lower_Bound(list[a][b][c][d], score, false);

            if (count == 0 || (int) list[a][b][c][d].get(list[a][b][c][d].size() - 1) < score)
                ++count;

            answer[i] = list[a][b][c][d].size() - count;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                solution(
                        new String[]{
                                "java backend junior pizza 150",
                                "python frontend senior chicken 210",
                                "python frontend senior chicken 150",
                                "cpp backend senior pizza 260",
                                "java backend junior chicken 80",
                                "python backend senior chicken 50"},
                        new String[]{
                                "java and backend and junior and pizza 100",
                                "python and frontend and senior and chicken 200",
                                "cpp and - and senior and pizza 250",
                                "- and backend and senior and - 150",
                                "- and - and - and chicken 100",
                                "- and - and - and - 150"}))); // [1,1,1,1,2,4]
    }
}
