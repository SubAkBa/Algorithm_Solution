import java.util.*;

public class Solution_carpet {
	public static int[] solution(int brown, int red) {
		int area = brown + red;
		int w = area;

		while(true) {
			if (area % w == 0) {
				int h = area / w;

				if ((area - (2 * (h + w - 2)) == red) && (2 * (h + w - 2)) == brown)
					return new int[] { w, h };
			}
			w--;
		}
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(10, 2)));
		System.out.println(Arrays.toString(solution(8, 1)));
		System.out.println(Arrays.toString(solution(24, 24)));
	}

}
