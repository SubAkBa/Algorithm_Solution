import java.util.*;

public class stack_9012_solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		sc.nextLine();
		
		for(int i=0;i<testcase;i++) {
			Stack<String> stack = new Stack<String>();
			String[] input = sc.nextLine().split("");
			String result = "YES";
			
			VPSloop : for(int j=0;j<input.length;j++) {
				if(input[j].equals("("))
					stack.push(input[j]);
				else {
					try {
						stack.pop();
					} catch(EmptyStackException e) {
						result = "NO";
						break VPSloop;
					}
				}
			}
			
			if(!stack.isEmpty())
				result = "NO";
			
			System.out.println(result);
		}
	}

}
