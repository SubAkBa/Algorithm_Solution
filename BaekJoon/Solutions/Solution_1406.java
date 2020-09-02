import java.util.*;
import java.io.*;

public class linkedlist_1406_solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Character> head = new Stack<Character>();
		Stack<Character> tail = new Stack<Character>();
		
		StringBuilder sb = new StringBuilder(br.readLine());
		StringBuilder input = new StringBuilder();
		
		int count = Integer.parseInt(br.readLine()), i = 0;
		
		for (i = 0; i < sb.length(); i++)
			head.push(sb.charAt(i));

		for (i = 0; i < count; i++) {
			input.append(br.readLine());
			
			switch(input.charAt(0)) {
			case 'P':
				head.push(input.charAt(2));
				break;
			case 'L':
				if(!head.isEmpty())
					tail.push(head.pop());
				break;
			case 'D':
				if(!tail.isEmpty())
					head.push(tail.pop());
				break;
			case 'B':
				if(!head.isEmpty())
					head.pop();
				break;
			}
			
			input.delete(0, 3);
		}
		
		while(!tail.isEmpty())
			head.push(tail.pop());
		
		while(!head.isEmpty())
			input.append(head.pop());
		
		System.out.println(input.reverse().toString());
	}

}
