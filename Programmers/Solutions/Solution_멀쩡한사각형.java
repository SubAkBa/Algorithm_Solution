
public class Solution_멀쩡한사각형 {

	public static long GCD(long a, long b) {
		if (b == 0)
			return a;
		else
			return GCD(b, a % b);
	}

	public static long solution(int w, int h) {
		long answer = 1;

		answer = (long) w * h - w - h + GCD(w, h);

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(8, 12));
	}
}
