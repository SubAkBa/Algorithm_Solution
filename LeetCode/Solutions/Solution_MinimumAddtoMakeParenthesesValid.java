public class Solution_MinimumAddtoMakeParenthesesValid {

    public static int minAddToMakeValid(String s) {
        int sLen = s.length();

        int leftPCount = 0, insertLeftPCount = 0;
        for (int i = 0; i < sLen; ++i) {
            if (s.charAt(i) == ')') {
                if (leftPCount == 0)
                    ++insertLeftPCount;
                else if (leftPCount > 0)
                    --leftPCount;
            } else
                ++leftPCount;
        }

        return insertLeftPCount + leftPCount;
    }

    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("())")); // 1
        System.out.println(minAddToMakeValid("(((")); // 3
        System.out.println(minAddToMakeValid("()))((")); // 4
    }
}
