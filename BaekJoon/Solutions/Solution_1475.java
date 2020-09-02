import java.util.*;
import java.io.*;

public class stringprocess_1475_solution {

// (1)
//	public static int solution(String str) {
//		int count = 1;
//		int[] arr = new int[10];
//		Arrays.fill(arr, 1);
//
//		for (int i = 0; i < str.length(); i++) {
//			int num = str.charAt(i) - '0';
//
//			if (arr[num] == 0) {
//				if (num == 6 && arr[9] > 0) {
//					arr[9]--;
//					continue;
//				} else if (num == 9 && arr[6] > 0) {
//					arr[6]--;
//					continue;
//				}
//				
//				count++;
//				for (int j = 0; j < arr.length; j++)
//					arr[j]++;
//			}
//			arr[num]--;
//		}
//
//		return count;
//	}

// (2)
public static int solution(String str) {
	int[] arr = new int[10];
	int max = 0, minidx = 0;

	for (int i = 0; i < str.length(); i++) {
		int temp = ++arr[str.charAt(i) - '0'];
		if (max < temp) {
			max = temp;
			minidx = str.charAt(i) - '0';
		}
	}
	
	if (minidx == 6 || minidx == 9)
		max = (arr[6] + arr[9] + 1) / 2;

	return max;
}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();

		bw.write(solution(str) + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
