public class Solution_CheckiftheSentenceIsPangram {

    public static boolean checkIfPangram(String sentence) {
        int bitFlag = 0, sLen = sentence.length();

        for (int i = 0; i < sLen; ++i) {
            bitFlag |= 1 << (sentence.charAt(i) - 'a');
        }

        return bitFlag == ((1 << 26) - 1);
    }

    public static void main(String[] args) {
        System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog")); // true
        System.out.println(checkIfPangram("leetcode")); // false
    }
}
