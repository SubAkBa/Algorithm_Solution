import java.util.*;

public class Solution_파일명정렬 {

	public static String[] solution(String[] files) {
		int fcount = files.length;
		String[][] file_info = new String[fcount][3];

		for (int i = 0; i < fcount; ++i) {
			int flen = files[i].length();

			int idx = 0, part_idx = 0;
			for (int j = 0; j < flen; ++j) {
				if (idx == 0 && Character.isDigit(files[i].charAt(j))) {
					file_info[i][idx++] = files[i].substring(part_idx, j);
					part_idx = j;
				} else if (idx == 1 && !Character.isDigit(files[i].charAt(j))) {
					file_info[i][idx++] = files[i].substring(part_idx, j);
					part_idx = j;
					break;
				}
			}

			if (idx == 1) {
				file_info[i][1] = files[i].substring(part_idx, flen);
				file_info[i][2] = "";
			} else
				file_info[i][2] = files[i].substring(part_idx, flen);
		}

		Arrays.sort(file_info, new Comparator<String[]>() {
			public int compare(String[] str1, String[] str2) {
				String lstr1 = str1[0].toLowerCase();
				String lstr2 = str2[0].toLowerCase();

				if (lstr1.equals(lstr2))
					return Integer.compare(Integer.parseInt(str1[1]), Integer.parseInt(str2[1]));

				return lstr1.compareTo(lstr2);
			}
		});

//		for (int i = 0; i < fcount; ++i)
//			System.out.println(Arrays.toString(file_info[i]));

		String[] answer = new String[fcount];

		for (int i = 0; i < fcount; ++i)
			answer[i] = file_info[i][0] + file_info[i][1] + file_info[i][2];

		return answer;
	}

	public static void main(String[] args) {
//		System.out.println(Arrays.toString(
//				solution(new String[] { "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG" })));
//		System.out.println(Arrays.toString(solution(
//				new String[] { "F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat" })));
		System.out.println(Arrays.toString(solution(new String[] { "foo9.txt", "foo010bar020.zip", "F-15" })));
	}
}
