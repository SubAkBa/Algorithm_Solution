import java.util.*;

public class Solution_FlattenNestedListIterator {

	public interface NestedInteger {

		public boolean isInteger();

		public Integer getInteger();

		public List<NestedInteger> getList();
	}

	public static class NestedIterator implements Iterator<Integer> {
		Stack<Integer> stack;

		public NestedIterator(List<NestedInteger> nestedList) {
			stack = new Stack<>();

			PushInteger(nestedList, nestedList.size());
		}

		public void PushInteger(List<NestedInteger> templist, int cursize) {
			for (int i = cursize - 1; i >= 0; i--) {
				NestedInteger temp = templist.get(i);

				if (!temp.isInteger())
					PushInteger(temp.getList(), temp.getList().size());
				else
					stack.push(temp.getInteger());
			}
		}

		@Override
		public Integer next() {
			return stack.pop();
		}

		@Override
		public boolean hasNext() {
			if (stack.isEmpty())
				return false;

			return true;
		}
	}

	public static void main(String[] args) {
//		NestedIterator i = new NestedIterator(nestedList);
//
//		while (i.hasNext())
//			v[f()] = i.next();
	}

}
