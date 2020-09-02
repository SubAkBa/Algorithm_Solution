import java.util.*;

public class linkedlist_1158_solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> list = new LinkedList<Integer>();
		StringBuffer sb = new StringBuffer();
		
		sb.append("<");

		int person = sc.nextInt();
		int idx = sc.nextInt();
		int temp = 0;

		for (int i = 1; i <= person; i++)
			list.add(i);

		while(!list.isEmpty()) {
			temp += idx - 1;

			while(temp >= list.size())
				temp -= list.size();
			
			sb.append(list.get(temp) + " ");
			list.remove(temp);
		}
		
		sb.deleteCharAt(sb.length() - 1);
		sb.append(">");
		
		System.out.println(sb.toString().replace(" ", ", "));
	}

}
