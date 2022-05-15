import java.util.*;

public class Solution_MinimumSumofFourDigitNumberAfterSplittingDigits {

    public static int minimumSum(int num) {
        final int LEN = 4;
        int[] numArr = new int[LEN];

        for (int i = 0; i < LEN; ++i) {
            numArr[i] = num % 10;
            num /= 10;
        }

        Arrays.sort(numArr);

        return numArr[0] * 10 + numArr[2] + numArr[1] * 10 + numArr[3];
    }

    public static void main(String[] args) {
        System.out.println(minimumSum(2932)); // 52
        System.out.println(minimumSum(4009)); // 13
    }
}
