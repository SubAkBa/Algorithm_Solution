import java.util.*;

public class week2assignment2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] input = sc.nextLine().toCharArray();
		
		Stack stack = new Stack();
		char pops;
		int temp = 1;
		int result = 0;
		
		mainloop: for(int i=0;i<input.length;i++) {
			switch(input[i]) 
			{
			case '(':
				stack.push(input[i]);
				temp *= 2;
				break;
			case '[':
				stack.push(input[i]);
				temp *= 3;
				break;
			case ')':
				try {
					pops = (char) stack.pop();
					if(pops == '[')
						throw new Exception();
				} catch(Exception e) {
					result = 0;
					break mainloop;
				}
				if(input[i - 1] == '(')
					result += temp;
				temp /= 2;
				break;
			case ']':
				try {
					pops = (char) stack.pop();
					if(pops == '(')
						throw new Exception();
				} catch(Exception e) {
					result = 0;
					break mainloop;
				}
				if(input[i - 1] == '[')
					result += temp;
				temp /= 3;
				break;
			}
		}
		
		if(!stack.isEmpty())
			result = 0;
		
		System.out.println(result);
	}

}
