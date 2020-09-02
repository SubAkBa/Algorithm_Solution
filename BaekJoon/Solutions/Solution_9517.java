import java.util.*;
import java.io.*;

public class simulation_9517_solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int idx = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int bombtime = 210, qaidx = 1;

		QA[] qa = new QA[N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			qa[i] = new QA(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
		}

		while (true) {
			bombtime -= qa[qaidx].time;
			
			if(bombtime <= 0)
				break;
			
			switch (qa[qaidx].type) {
			case 'T':
				idx++;
				if (idx == 9)
					idx = 1;
				break;
			}
			
			qaidx++;
		}

		bw.write(idx + " ");

		bw.flush();
		bw.close();
		br.close();
	}

}

class QA {
	int time;
	char type;

	public QA(int time, char type) {
		this.time = time;
		this.type = type;
	}
}