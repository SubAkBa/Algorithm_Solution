import java.util.*;
import java.io.*;

public class greedy_2875_solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int female = Integer.parseInt(st.nextToken());
		int male = Integer.parseInt(st.nextToken());
		int intern = Integer.parseInt(st.nextToken());
		int team = 0;

		team = Math.min(female / 2, male);
		team = Math.min(team, (female + male - intern) / 3);

		System.out.println(team);
	}

}
