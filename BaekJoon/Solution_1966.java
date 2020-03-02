import java.util.*;

public class week2assignment3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		
		for(int testcount=0; testcount<testcase; testcount++) {
			Queue<Integer> queue = new LinkedList<Integer>();
			int count = sc.nextInt();
			int answeridx = sc.nextInt();
			int impidx = count - 1, order = 1;
			
			int[] numbers = new int[count];
			for(int i=0;i<count;i++) {
				numbers[i] = sc.nextInt();
				queue.add(numbers[i]);
			}
			Arrays.sort(numbers);
			
			while(true) {
				if(answeridx == 0 && numbers[impidx] == queue.peek())
					break;
				
				if(numbers[impidx] == queue.peek()) {
					queue.poll();
					order++;
					impidx--;
					answeridx--;
				}
				else {
					queue.add(queue.poll());
					if(answeridx == 0)
						answeridx = queue.size() - 1;
					else
						answeridx--;
				}
	
			}
			System.out.println(order);
		}
	}
}
