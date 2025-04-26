import java.util.ArrayList;
import java.util.List;

public class Solution_PascalsTriangleII {
	public static List<Integer> getRow(int rowIndex) {
		if (rowIndex == 0) {
			return List.of(1);
		}

		if (rowIndex == 1) {
			return List.of(1, 1);
		}

		List<Integer> prevList = List.of(1, 1);
		List<Integer> currentList = new ArrayList<>();
		for (int i = 2; i <= rowIndex; ++i) {
			currentList.clear();

			currentList.add(1);

			for (int j = 1; j < prevList.size(); ++j) {
				currentList.add(prevList.get(j - 1) + prevList.get(j));
			}

			currentList.add(1);

			prevList = List.copyOf(currentList);
		}

		return currentList;
	}

	public static void main(String[] args) {
		System.out.println(getRow(3)); // [1,3,3,1]
		System.out.println(getRow(0)); // [1]
		System.out.println(getRow(1)); // [1,1]
	}
}
