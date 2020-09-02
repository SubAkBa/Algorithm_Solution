import java.util.*;
import java.io.*;

public class floyd_11562_solution {
	static int building, pcount;
	static int[][] path;
	final static int INF = 987654321;

	public static void Floyd_Warshall() {
		for (int via = 1; via <= building; via++) {
			for (int from = 1; from <= building; from++) {
				for (int to = 1; to <= building; to++) {
					path[from][to] = Math.min(path[from][to], path[from][via] + path[via][to]);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] info1 = br.readLine().split(" ");
		building = Integer.parseInt(info1[0]);
		pcount = Integer.parseInt(info1[1]);

		path = new int[building + 1][building + 1];

		for (int i = 1; i <= building; i++) {
			for (int j = 1; j <= building; j++) {
				if(i == j)
					path[i][j] = 0;
				else
					path[i][j] = INF;
			}
		}

		for (int i = 0; i < pcount; i++) {
			String[] info2 = br.readLine().split(" ");

			int from = Integer.parseInt(info2[0]);
			int to = Integer.parseInt(info2[1]);
			int cate = Integer.parseInt(info2[2]);

			switch (cate) {
			case 0:
				path[from][to] = 0;
				path[to][from] = 1;
				break;
			case 1:
				path[from][to] = path[to][from] = 0;
				break;
			}
		}

		Floyd_Warshall();

		int qcount = Integer.parseInt(br.readLine());

		for (int i = 0; i < qcount; i++) {
			String[] quest = br.readLine().split(" ");

			int from = Integer.parseInt(quest[0]);
			int to = Integer.parseInt(quest[1]);

			sb.append(path[from][to] + "\n");
		}

		bw.write(sb.toString());

		bw.flush();
		bw.close();
		br.close();
	}

}
