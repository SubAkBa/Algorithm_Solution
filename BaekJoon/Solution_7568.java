import java.io.*;
import java.util.*;

public class bruteforce_7568_solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		int[] rank = new int[num];

		Arrays.fill(rank, 1);

		ArrayList<Person> list = new ArrayList<Person>();

		for (int i = 0; i < num; i++) {

			String[] infos = br.readLine().split(" ");

			list.add(new Person(Integer.parseInt(infos[0]), Integer.parseInt(infos[1])));
		}

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if(i == j)
					continue;
				
				if(list.get(i).CompareBody(list.get(j)))
					rank[j]++;
			}
		}
		
		for(int r : rank)
			System.out.print(r + " ");
	}

}

class Person {
	int weight, height;

	public Person(int w, int h) {
		this.weight = w;
		this.height = h;
	}
	
	public boolean CompareBody(Person p) {
		return (weight > p.weight && height > p.height);
	}
}