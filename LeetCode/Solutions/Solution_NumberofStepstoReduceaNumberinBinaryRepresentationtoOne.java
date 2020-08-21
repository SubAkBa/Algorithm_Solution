
public class Solution_NumberofStepstoReduceaNumberinBinaryRepresentationtoOne {

	public static int numSteps(String s) {
		int idx = s.length() - 1;
		int step = 0, plus = 0;
		char[] ch = s.toCharArray();

		while (idx > 0) {
			if (plus == 1) {
				if (ch[idx] == '0') {
					ch[idx] = '1';
					plus = 0;
				} else
					ch[idx] = '0';
			}

			if (ch[idx] == '1') {
				++step;
				plus = 1;
			}

			--idx;
			++step;
		}

		return step + plus;
	}

	public static void main(String[] args) {
		System.out.println(numSteps("1101")); // 6
		System.out.println(numSteps("10")); // 1
		System.out.println(numSteps("1")); // 0
		System.out.println(numSteps("1111011110000011100000110001011011110010111001010111110001")); // 85
	}
}
