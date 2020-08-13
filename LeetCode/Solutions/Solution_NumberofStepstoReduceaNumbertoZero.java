
public class Solution_NumberofStepstoReduceaNumbertoZero {

	public static int numberOfSteps(int num) {
		int step = 0;

		while (num > 0) {
			if (num % 2 == 1)
				--num;
			else
				num >>= 1;

			++step;
		}

		return step;
	}

	public static void main(String[] args) {
		System.out.println(numberOfSteps(14));
		System.out.println(numberOfSteps(8));
		System.out.println(numberOfSteps(123));
	}
}
