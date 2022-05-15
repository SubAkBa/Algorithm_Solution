import java.util.PriorityQueue;
import java.util.StringJoiner;

public class Solution_SortingtheSentence {

    public static String sortSentence(String s) {
        String[] strPart = s.split(" ");
        int partCount = strPart.length;
        String[] sortedStrPart = new String[partCount];

        for (String str : strPart) {
            int len = str.length();
            sortedStrPart[str.charAt(len - 1) - '0' - 1] = str.substring(0, len - 1);
        }

        StringJoiner joiner = new StringJoiner(" ");

        for (String str : sortedStrPart) {
            joiner.add(str);
        }

        return joiner.toString();
    }

    public static void main(String[] args) {
        System.out.println(sortSentence("is2 sentence4 This1 a3")); // "This is a sentence"
        System.out.println(sortSentence("Myself2 Me1 I4 and3")); // "Me Myself and I"
    }
}
