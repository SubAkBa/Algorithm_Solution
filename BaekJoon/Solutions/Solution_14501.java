import java.util.*;
import java.io.*;

public class dfs_14501_solution {
	static int maxmoney = 0;

	public static void GetMaxMoney(ArrayList<Counsel> list, int idx, int tempmoney) {

		if (idx >= list.size()) {

			maxmoney = Math.max(maxmoney, tempmoney);

			return;
		}

		for (int i = idx; i < list.size(); i++) {
			if(i + list.get(i).time > list.size())
				GetMaxMoney(list, i + list.get(i).time, tempmoney);
			else
				GetMaxMoney(list, i + list.get(i).time, tempmoney + list.get(i).money);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		ArrayList<Counsel> list = new ArrayList<Counsel>();

		for (int i = 0; i < num; i++)
			list.add(new Counsel(br.readLine().split(" ")));

		GetMaxMoney(list, 0, 0);

		System.out.println(maxmoney);
	}

}

class Counsel {
	int time, money;

	public Counsel(String[] info) {
		this.time = Integer.parseInt(info[0]);
		this.money = Integer.parseInt(info[1]);
	}
}