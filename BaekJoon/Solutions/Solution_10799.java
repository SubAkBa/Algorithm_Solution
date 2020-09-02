import java.util.*;

public class week2assignment {
	static Stack input = new Stack();
	
	public static void CalculatePipeCount(char[] pipe) {
		int idx = 0, count = 0;
		
		
		while(idx != pipe.length) {
			
			if(pipe[idx] == ')') {
				input.pop();
				
				if(pipe[idx - 1] == '(')
					count += input.size();
				else
					count++;
			}
			else
				input.push(pipe[idx]);

			idx++;
		}

		System.out.println(count);
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		char[] pipe = sc.nextLine().toCharArray();
		
		CalculatePipeCount(pipe);
	}
}
