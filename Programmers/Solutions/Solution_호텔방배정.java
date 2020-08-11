import java.util.*;

public class Solution_hotelroomassignment {

	public static long Find(HashMap<Long, Long> parent, long u) {
		if (!parent.containsKey(u)) {
			parent.put(u, u);
			return u;
		}

		if (parent.get(u) == u)
			return u;

		long p = Find(parent, parent.get(u));
		parent.put(u, p);

		return p;
	}

	public static void Union(HashMap<Long, Long> parent, long u, long v) {
		long uR = Find(parent, u);
		long vR = Find(parent, v);

		if (uR == vR)
			return;

		parent.put(uR, vR);
	}

	public static long[] solution(long k, long[] room_number) {
		int len = room_number.length;
		long[] answer = new long[len];
		HashMap<Long, Long> parent = new HashMap<>();

		for (int i = 0; i < len; i++) {
			long room = Find(parent, room_number[i]);
			Union(parent, room, room + 1);
			answer[i] = room;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(10, new long[] { 1, 3, 4, 1, 3, 1 })));
	}

}
