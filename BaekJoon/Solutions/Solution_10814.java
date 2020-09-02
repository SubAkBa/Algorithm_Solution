import java.util.*;
import java.io.*;

public class Solution_10814 {

	public static class Person implements Comparable<Person> {
		int age;
		String name;

		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}

		public int compareTo(Person p) {
			return this.age - p.age;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		Person[] p = new Person[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			p[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken());
		}

		Arrays.sort(p);

		for (int i = 0; i < N; i++)
			bw.write(p[i].age + " " + p[i].name + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

}
