import java.util.*;

public class Solution_RearrangeWordsinaSentence {

    public static String arrangeWords(String text) {
        String[] text_parts = text.split(" ");
        text_parts[0] = (char) (text_parts[0].charAt(0) ^ (1 << 5)) + "" + text_parts[0].substring(1);

        Arrays.sort(text_parts, (a, b) -> Integer.compare(a.length(), b.length()));

        StringBuilder sb = new StringBuilder();

        int count = text_parts.length;

        sb.append((char) (text_parts[0].charAt(0) ^ (1 << 5)) + "" + text_parts[0].substring(1));
        for (int i = 1; i < count; ++i)
            sb.append(" " + text_parts[i]);

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(arrangeWords("Leetcode is cool")); // "Is cool leetcode"
        System.out.println(arrangeWords("Keep calm and code on")); // "On and keep calm code"
        System.out.println(arrangeWords("To be or not to be")); // "To be or to be not"
    }
}
