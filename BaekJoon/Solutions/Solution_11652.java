import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Solution_11652 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		HashMap<Long, Integer> cardlist = new HashMap<>();

		for (int i = 0; i < N; i++) {
			long num = Long.parseLong(br.readLine());

			cardlist.put(num, cardlist.getOrDefault(num, 0) + 1);
		}

		List<Entry<Long, Integer>> sorted = new ArrayList<>(cardlist.entrySet());

		Collections.sort(sorted, new Comparator<Entry<Long, Integer>>() {
			public int compare(Entry<Long, Integer> e1, Entry<Long, Integer> e2) {
				if (e1.getValue().equals(e2.getValue()))
					return e1.getKey().compareTo(e2.getKey());

				return e2.getValue().compareTo(e1.getValue());
			}
		});

		bw.write(sorted.get(0).getKey() + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
