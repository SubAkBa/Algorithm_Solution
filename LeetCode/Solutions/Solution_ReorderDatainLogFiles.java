import java.util.*;

public class Solution_ReorderDatainLogFiles {

//	public static String[] reorderLogFiles(String[] logs) {
//		int len = logs.length;
//
//		Arrays.sort(logs, new Comparator<String>() {
//			public int compare(String s1, String s2) {
//				String[] split1 = s1.split(" ", 2);
//				String[] split2 = s2.split(" ", 2);
//
//				boolean isdigit1 = Character.isDigit(split1[1].charAt(0));
//				boolean isdigit2 = Character.isDigit(split2[1].charAt(0));
//
//				if (!isdigit1 && !isdigit2) {
//					int comp = split1[1].compareTo(split2[1]);
//					if (comp == 0)
//						return split1[0].compareTo(split2[0]);
//
//					return comp;
//				}
//
//				if (!isdigit1 && isdigit2)
//					return -1;
//				else if (isdigit1 && !isdigit2)
//					return 1;
//
//				return 0;
//			}
//		});
//
//		return logs;
//	}

	public static String[] reorderLogFiles(String[] logs) {
		int len = logs.length;

		List<String> diglist = new ArrayList<>();
		List<String> letlist = new ArrayList<>();

		for (String log : logs) {
			String[] split = log.split(" ");

			if (Character.isDigit(split[1].charAt(0)))
				diglist.add(log);
			else
				letlist.add(log);
		}

		Collections.sort(letlist, new Comparator<String>() {
			public int compare(String s1, String s2) {
				String[] split1 = s1.split(" ", 2);
				String[] split2 = s2.split(" ", 2);

				int comp = split1[1].compareTo(split2[1]);
				if (comp == 0)
					return split1[0].compareTo(split2[0]);

				return comp;
			}
		});

		String[] result = new String[len];
		int idx = 0;
		for (String let : letlist)
			result[idx++] = let;

		for (String dig : diglist)
			result[idx++] = dig;

		return result;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(reorderLogFiles(
				new String[] { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" })));
		// ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
		System.out.println(Arrays.toString(reorderLogFiles(
				new String[] { "a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo" })));
		// ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
	}
}