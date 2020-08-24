import java.util.*;

public class Solution_무지의먹방라이브 {

	public static int solution(int[] food_times, long k) {
		Comparator<int[]> comptime = new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		};

		Comparator<int[]> compidx = new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		};

        List<int[]> list = new ArrayList<>();
        
		int flen = food_times.length;
		long sum = 0;
		for (int i = 0; i < flen; ++i) {
			sum += food_times[i];
			list.add(new int[] { food_times[i], i + 1 });
		}

		if (sum <= k)
			return -1;

		Collections.sort(list, comptime);

		int prevtime = 0, n = flen;
        
		for (int i = 0; i < flen; ++i) {
            int time = list.get(i)[0];
			long diff = time - prevtime;

			if (diff != 0) {
				long spend = diff * n;

				if (spend <= k) {
					k -= spend;
					prevtime = time;
				} else {
					Collections.sort(list.subList(i, flen), compidx);
					return list.get((int) (k % n) + i)[1];
				}
			}

			--n;
		}

		return -1;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 3, 1, 2 }, 5)); // 1
		System.out.println(solution(new int[] { 5, 6, 6, 5, 4, 5, 7, 8, 9 }, 30)); // 4
		System.out.println(solution(new int[] { 8, 6, 4 }, 15)); // 2
		System.out.println(solution(new int[] { 946, 314, 757, 322, 559, 647, 983, 482, 145 }, 1833)); // 1
		System.out.println(
				solution(new int[] { 100000000, 100000000, 100000000, 100000000, 100000000, 100000000 }, 9000002)); // 3
		System.out.println(
				solution(new int[] { 100000000, 100000000, 100000000, 100000000, 100000000, 100000000 }, 500000020)); // 5
		System.out.println(solution(new int[] { 1, 5, 5, 5, 5, 6, 7 }, 31)); // 6
		System.out.println(solution(new int[] { 100000000, 100000000, 100000000, 5, 5, 6, 7 }, 100000000)); // 3
		System.out.println(solution(new int[] { 5, 5, 5, 5, 5, 5, 5 }, 5)); // 6
		System.out.println(solution(new int[] { 1 }, 4)); // -1
		System.out.println(solution(new int[] { 5 }, 4)); // 1
	}
}
