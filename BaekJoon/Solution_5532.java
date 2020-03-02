import java.util.*;
import java.io.*;

public class simulation_5532_solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int vacation = Integer.parseInt(br.readLine());
		int langpage = Integer.parseInt(br.readLine());
		int mathpage = Integer.parseInt(br.readLine());
		int solvelang = Integer.parseInt(br.readLine());
		int solvemath = Integer.parseInt(br.readLine());
		
		int langs = langpage / solvelang + (langpage % solvelang == 0 ? 0 : 1);
		int maths = mathpage / solvemath + (mathpage % solvemath == 0 ? 0 : 1);
		int day = Math.max(langs, maths);
		
		bw.write((vacation - day) + " ");
		
		bw.flush();
		bw.close();
		br.close();
	}

}
