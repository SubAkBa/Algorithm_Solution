import java.util.*;
import java.io.*;

public class simulation_1173_solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int ex = Integer.parseInt(st.nextToken());
		int min = Integer.parseInt(st.nextToken());
		int max = Integer.parseInt(st.nextToken());
		int up = Integer.parseInt(st.nextToken());
		int down = Integer.parseInt(st.nextToken());
		int cur = min, time = 0;

		while (true) {
			if (cur == min && cur + up > max) {
				time = -1;
				break;
			}

			if (cur + up > max) { // 휴식
				if (cur - down < min)
					cur = min;
				else
					cur -= down;
			} else { // 운동
				cur += up;
				ex--;
			}

			time++;

			if (ex == 0)
				break;
		}

		bw.write(time + " ");

		bw.flush();
		bw.close();
		br.close();
	}

}
