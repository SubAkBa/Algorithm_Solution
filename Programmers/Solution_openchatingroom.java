import java.util.*;

public class Solution_openchatingroom {
	
	public static String[] solution(String[] record) {
		HashMap<String, String> userlist = new HashMap<>();
		ArrayList<String> msglist = new ArrayList<>();

		for (int i = 0; i < record.length; i++) {
			String[] info = record[i].split(" ");

			if (!info[0].equals("Leave"))
				userlist.put(info[1], info[2]);
		}

		for (int i = 0; i < record.length; i++) {
			String[] info = record[i].split(" ");

			if (info[0].equals("Enter"))
				msglist.add(userlist.get(info[1]) + "님이 들어왔습니다.");
			else if (info[0].equals("Leave"))
				msglist.add(userlist.get(info[1]) + "님이 나갔습니다.");
		}

		String[] answer = new String[msglist.size()];
		for (int i = 0; i < answer.length; i++)
			answer[i] = msglist.get(i);

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] { "Enter uid1234 Muzi", "Enter uid4567 Prodo",
				"Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan" })));
	}

}
