public class Solution_FindCenterofStarGraph {

    public int findCenter(int[][] edges) {
        int centerNode = edges[0][0] + edges[0][1];

        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1])
            centerNode = edges[0][0];
        else if (edges[0][1] == edges[1][0] || edges[0][1] == edges[1][1])
            centerNode = edges[0][1];

        return centerNode;
    }
}
