import java.util.*;

public class Solution_다트게임 {
	
	public static int solution(String dartResult) {
		Stack<Integer> stack = new Stack<>();
		int total = 0, nextnum = 0;
		String temp = "";

		for (char c : dartResult.toCharArray()) {
			if (Character.isDigit(c))
				temp += c;
			else {
				if (!temp.equals("")) {
					stack.push(Integer.parseInt(temp));
					temp = "";
				}

				switch (c) {
				case 'D':
					stack.push((int) Math.pow(stack.pop(), 2));
					break;
				case 'T':
					stack.push((int) Math.pow(stack.pop(), 3));
					break;
				case '*':
					if (stack.size() >= 2) {
						nextnum = stack.pop();
						stack.push(stack.pop() * 2);
						stack.push(nextnum * 2);
					} else
						stack.push(stack.pop() * 2);
					break;
				case '#':
					stack.push(stack.pop() * -1);
					break;
				}
			}
		}

		while (!stack.isEmpty())
			total += stack.pop();

		return total;
	}

	public static void main(String[] args) {
		System.out.println(solution("1S2D*3T"));
		System.out.println(solution("1D2S#10S"));
		System.out.println(solution("1D2S0T"));
		System.out.println(solution("1S*2T*3S"));
		System.out.println(solution("1D#2S*3S"));
		System.out.println(solution("1T2D3D#"));
		System.out.println(solution("1D2S3T*"));
	}
}
