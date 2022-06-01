public class Solution_FindtheTownJudge {

    public int findJudge(int n, int[][] trust) {
        int[] indeg = new int[n + 1];
        int[] outdeg = new int[n + 1];
        int tLen = trust.length;

        for (int[] t : trust) {
            --outdeg[t[0]];
            ++indeg[t[1]];
        }

        int judge = -1;
        for (int i = 1; i <= n; ++i) {
            if (indeg[i] == n - 1 && outdeg[i] == 0) {
                judge = i;
                break;
            }
        }

        return judge;
    }
}
