import java.util.*;
import java.io.*;

public class Solution_lunchtime {
	static ArrayList<Person> people;
	static ArrayList<Stair> stairs;
	static int N, len, answer;

	public static int DownStair(ArrayList<Person> team, int idx) {
		int size = team.size();

		if (size == 0)
			return 0;

		ArrayList<Person> temp = new ArrayList<>();
		temp.addAll(team);

		Collections.sort(temp, new Comparator<Person>() {
			public int compare(Person p1, Person p2) {
				return p1.dist[idx] - p2.dist[idx];
			}
		});

		for (int i = 0; i < size; i++) {
			if (i < 3)
				temp.get(i).endtime = temp.get(i).dist[idx] + stairs.get(idx).l;
			else
				temp.get(i).endtime = (temp.get(i - 3).endtime <= temp.get(i).dist[idx] ? temp.get(i).dist[idx]
						: temp.get(i - 3).endtime) + stairs.get(idx).l;
		}

		return temp.get(size - 1).endtime;
	}

	public static void GoStair(ArrayList<Person>[] teams, int idx) {
		if (idx == len) {
			answer = Math.min(answer, Math.max(DownStair(teams[0], 0), DownStair(teams[1], 1)));
			return;
		}

		teams[0].add(people.get(idx));
		GoStair(teams, idx + 1);

		teams[0].remove(teams[0].size() - 1);

		teams[1].add(people.get(idx));
		GoStair(teams, idx + 1);

		teams[1].remove(teams[1].size() - 1);
	}

	public static class Stair {
		int x, y, l;

		public Stair(int x, int y, int l) {
			this.x = x;
			this.y = y;
			this.l = l;
		}
	}

	public static class Person {
		int x, y, endtime;
		int[] dist = new int[2];

		public Person(int x, int y, int distA, int distB, int endtime) {
			this.x = x;
			this.y = y;
			this.dist[0] = distA;
			this.dist[1] = distB;
			this.endtime = endtime;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine()), count = 0;

		while ((count++) < T) {
			N = Integer.parseInt(br.readLine());
			people = new ArrayList<>();
			stairs = new ArrayList<>();
			answer = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for (int j = 0; j < N; j++) {
					int num = Integer.parseInt(st.nextToken());

					if (num == 1)
						people.add(new Person(i, j, 0, 0, 0));
					else if (num > 1)
						stairs.add(new Stair(i, j, num));
				}
			}

			len = people.size();

			for (int i = 0; i < len; i++) {
				people.get(i).dist[0] = Math.abs(people.get(i).x - stairs.get(0).x)
						+ Math.abs(people.get(i).y - stairs.get(0).y) + 1;
				people.get(i).dist[1] = Math.abs(people.get(i).x - stairs.get(1).x)
						+ Math.abs(people.get(i).y - stairs.get(1).y) + 1;
			}

			GoStair(new ArrayList[] { new ArrayList<Person>(), new ArrayList<Person>() }, 0);

			bw.write("#" + count + " " + answer + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}