import java.util.*;
import java.io.*;

public class eratos_2960_solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[1001];
		boolean flag = false;
		int num = 2, C = 0, answer = 0;

		while (true) {
			for (int i = num; i <= N; i += num) {
				
				if(visited[i])
					continue;
				
				C++;
				visited[i] = true;
				
				if(C == K) {
					answer = i;
					flag = true;
					break;
				}
			}
			
			if(flag)
				break;
			
			num++;
		}
		
		bw.write(answer + " ");

		bw.flush();
		bw.close();
		br.close();
	}

}
