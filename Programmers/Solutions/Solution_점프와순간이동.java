import java.util.*;

public class Solution_jumpandteleport {
	public static int solution(int n) {
		int ans = 0;

		while (n > 0) {
			while (n % 2 == 0)
				n /= 2;

			n -= 1;
			ans++;
		}

		return ans;
	}

	public static void main(String[] args) {
		System.out.println(solution(5));
		System.out.println(solution(6));
		System.out.println(solution(5000));
	}

}
