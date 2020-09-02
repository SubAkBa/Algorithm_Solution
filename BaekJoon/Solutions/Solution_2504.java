import java.util.*;
import java.io.*;

public class Solution_2504 {
	
	public static int solution(String str) {
		Stack<Character> pair = new Stack<>();

		char[] ctr = str.toCharArray();
		boolean err = false;
		int sum = 0, temp = 1;

		for (int i = 0; i < ctr.length && !err; i++) {

			switch (ctr[i]) {
			case '[':
				pair.push(ctr[i]);
				temp *= 3;
				break;
			case '(':
				pair.push(ctr[i]);
				temp *= 2;
				break;
			case ']':
				if (pair.isEmpty()) {
					err = true;
					sum = 0;
					continue;
				}

				if (pair.peek() == '[') {
					if(ctr[i - 1] != ']' && ctr[i - 1] != ')')
						sum += temp;
					pair.pop();
				} else {
					err = true;
					sum = 0;
					continue;
				}
				
				temp /= 3;
				break;
			case ')':
				if (pair.isEmpty()) {
					err = true;
					sum = 0;
					continue;
				}

				if (pair.peek() == '(') {
					if(ctr[i - 1] != ']' && ctr[i - 1] != ')')
						sum += temp;
					pair.pop();
				} else {
					err = true;
					sum = 0;
					continue;
				}
				
				temp /= 2;
				break;
			}
		}

		if (!pair.isEmpty())
			sum = 0;
		
		return sum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		

		bw.write(solution(str) + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
