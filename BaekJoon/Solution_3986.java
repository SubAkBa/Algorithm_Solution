import java.util.*;
import java.io.*;

public class stack_3986_solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();

		int wordcount = Integer.parseInt(br.readLine()), goodword = 0;
		String word;

		for (int i = 0; i < wordcount; i++) {
			word = br.readLine();

			for (int j = 0; j < word.length(); j++) {

				if (stack.isEmpty())
					stack.push(word.charAt(j));
				else {
					if (word.charAt(j) == stack.peek())
						stack.pop();
					else
						stack.push(word.charAt(j));
				}

			}

			if (stack.isEmpty())
				goodword++;
			else {
				while (!stack.isEmpty())
					stack.pop();
			}
		}

		System.out.println(goodword);
	}
}
