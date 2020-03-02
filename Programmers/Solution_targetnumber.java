import java.util.*;

public class Solution_targetnumber {

	public static int DFS(int[] numbers, int curnode, int sum, int target) {
		if(curnode == numbers.length) {
			if(sum == target)
				return 1;
			return 0;
		}
		
		return DFS(numbers, curnode + 1, sum + numbers[curnode], target) +
				DFS(numbers, curnode + 1, sum - numbers[curnode], target);
	}

	public static int solution(int[] numbers, int target) {
		int answer = DFS(numbers, 0, 0, target);

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 1, 1, 1, 1 }, 3));
	}

}
