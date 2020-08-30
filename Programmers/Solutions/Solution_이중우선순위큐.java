import java.util.*;

public class Solution_doublepriorityqueue {

	public static int[] solution(String[] operations) {
		int[] answer = null;
		int len = operations.length;
		LinkedList<Integer> list = new LinkedList<>();

		for (int i = 0; i < len; i++) {
			StringTokenizer st = new StringTokenizer(operations[i]);
			String oper = st.nextToken();
			int num = Integer.parseInt(st.nextToken());

			switch (oper) {
			case "I":
				int idx = 0;
				if (list.isEmpty())
					list.add(num);
				else {
					if (list.getLast() >= num)
						list.addLast(num);
					else {
						while (list.get(idx) > num)
							idx++;
						list.add(idx, num);
					}
				}
				break;
			case "D":
				if (!list.isEmpty()) {
					if (num == 1)
						list.removeFirst();
					else
						list.removeLast();
				}
				break;
			}
		}

		if (list.isEmpty())
			answer = new int[] { 0, 0 };
		else
			answer = new int[] { list.getFirst(), list.getLast() };

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] { "I 16", "D 1" })));
		System.out.println(Arrays.toString(solution(new String[] { "I 7", "I 5", "I -5", "D -1" })));
	}

}
