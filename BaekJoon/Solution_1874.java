import java.util.*;

public class stack_1874_solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		
		int testcase = sc.nextInt();
		int current = 0, pops = 0;
		StringBuffer sb = new StringBuffer();
		String result = "";
		boolean noflag = false;

		for (int i = 0; i < testcase; i++) {
			int num = sc.nextInt();

			if (!noflag) {
				if (current < num) {
					while (current != num) {
						stack.push(++current);
						sb.append("+\n");
					}

					stack.pop();
					sb.append("-\n");
				} else if (current >= num) {
					if (stack.peek() > num) {
						result = "NO";
						noflag = true;
					} else {
						while ((pops = stack.pop()) != num)
							sb.append("-\n");

						sb.append("-\n");
					}
				}
			}
		}
		
		if(result.equals(""))
			result = sb.toString();
		
		System.out.println(result);
	}

}
