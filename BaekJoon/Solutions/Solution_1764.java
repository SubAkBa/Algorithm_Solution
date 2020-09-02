import java.util.*;
import java.io.*;

public class stringprocess_1764_solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		HashSet<String> hs = new HashSet<>();
		ArrayList<String> list = new ArrayList<>();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++)
			hs.add(br.readLine());

		for (int i = 0; i < M; i++) {
			String temp = br.readLine();

			if (hs.contains(temp))
				list.add(temp);
		}
		
		Collections.sort(list);

		bw.write(list.size() + "\n");
		for (int i = 0; i < list.size(); i++)
			bw.write(list.get(i) + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

}