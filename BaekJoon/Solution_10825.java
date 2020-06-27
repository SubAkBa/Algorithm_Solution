import java.util.*;
import java.io.*;

public class Solution_10825 {

	public static class Person implements Comparable<Person> {
		String name;
		int lang, eng, math;

		public Person(String name, int lang, int eng, int math) {
			this.name = name;
			this.lang = lang;
			this.eng = eng;
			this.math = math;
		}

		public int compareTo(Person p) {
			if (this.lang == p.lang) {
				if (this.eng == p.eng) {
					if (this.math == p.math)
						return this.name.compareTo(p.name);

					return p.math - this.math;
				}

				return this.eng - p.eng;
			}

			return p.lang - this.lang;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		Person[] p = new Person[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			p[i] = new Person(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(p);

		for (int i = 0; i < N; i++)
			bw.write(p[i].name + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

}
