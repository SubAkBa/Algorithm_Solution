import java.util.Stack;

public class Solution_ValidParenthesisString {

    public static boolean checkValidString(String s) {
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> asteriskStack = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                leftStack.push(i);
            } else if (s.charAt(i) == ')') {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else if (!asteriskStack.isEmpty()) {
                    asteriskStack.pop();
                } else
                    return false;
            } else
                asteriskStack.push(i);
        }

        while (!leftStack.isEmpty() && !asteriskStack.isEmpty()) {
            int leftIdx = leftStack.pop();
            int asteriskIdx = asteriskStack.pop();

            if (leftIdx > asteriskIdx)
                return false;
        }

        if (!leftStack.isEmpty()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
//        System.out.println(checkValidString("()")); // true
//        System.out.println(checkValidString("(*)")); // true
//        System.out.println(checkValidString("(*))")); // true
        System.out.println(checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()")); // true
    }
}
