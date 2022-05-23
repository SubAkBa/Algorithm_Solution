public class Solution_JewelsandStones {

    public static int numJewelsInStones(String jewels, String stones) {
        boolean[] isExisted = new boolean[128];

        int jLen = jewels.length(), sLen = stones.length();

        for (int i = 0; i < jLen; ++i) {
            isExisted[jewels.charAt(i)] = true;
        }

        int count = 0;
        for (int i = 0; i < sLen; ++i) {
            if (isExisted[stones.charAt(i)]) {
                ++count;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(numJewelsInStones("z", "ZZ"));
    }
}
