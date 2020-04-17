import java.util.*;

public class Solution_lifeboat {

	public static int solution(int[] people, int limit) {
		int answer = 0, idx = 0, i = people.length - 1;
		Arrays.sort(people);

		for (; i > idx; i--) {
			if (people[i] + people[idx] > limit) {
				answer++;
			} else {
				idx++;
				answer++;
			}
		}

		if (i == idx)
			answer++;

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 70, 50, 80, 50 }, 100));
		System.out.println(solution(new int[] { 70, 80, 50 }, 100));
	}

}
