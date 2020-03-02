import java.util.*;
import java.io.*;

public class stack_5397_solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testcase = Integer.parseInt(br.readLine());

		Stack<Character> curleft = new Stack<Character>();
		Stack<Character> curright = new Stack<Character>();

		StringBuilder sb = new StringBuilder();
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < testcase; i++) {

			sb.append(br.readLine());

			for (int j = 0; j < sb.length(); j++) {
				
				switch(sb.charAt(j)) {
				case '<':
					if(!curleft.isEmpty())
						curright.push(curleft.pop());
					break;
				case '>':
					if(!curright.isEmpty())
						curleft.push(curright.pop());
					break;
				case '-':
					if(!curleft.isEmpty())
						curleft.pop();
					break;
				default:
					curleft.push(sb.charAt(j));	
				}
			}
			
			sb.delete(0, sb.length());
			
			while(!curleft.isEmpty())
				curright.push(curleft.pop());
			
			while(!curright.isEmpty())
				result.append(curright.pop());

			result.append("\n");
		}
		
		System.out.println(result.toString());
	}

}
