import java.util.*;

import javafx.util.*;
import java.io.*;

public class stack_2493_solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Pair<Integer, Integer>> top1 = new Stack<Pair<Integer, Integer>>();
		Stack<Pair<Integer, Integer>> top2 = new Stack<Pair<Integer, Integer>>();
		int topcount = Integer.parseInt(br.readLine());

		String[] toplist = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		int[] idxlist = new int[topcount];

		for (int i = 0; i < topcount; i++)
			top1.push(new Pair<Integer, Integer>(i, Integer.parseInt(toplist[i])));

		int idx = topcount;
		Pair<Integer, Integer> currenttop;

		while (!top1.isEmpty()) {

			if (top2.isEmpty()) {
				top2.push(top1.pop());
				idx--;
			} else {
				currenttop = top1.pop();

				while (!top2.isEmpty() && currenttop.getValue() > top2.peek().getValue())
					idxlist[top2.pop().getKey()] = idx;

				top2.push(currenttop);
				idx--;
			}
		}

		if (!top2.isEmpty()) {
			while (!top2.isEmpty())
				idxlist[top2.pop().getKey()] = idx;
		}
		
		for(int answer : idxlist)
			sb.append(answer + " ");
		
		System.out.println(sb.toString().trim());
	}
}
