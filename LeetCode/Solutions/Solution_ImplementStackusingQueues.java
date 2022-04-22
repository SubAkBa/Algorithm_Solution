import java.util.*;

public class Solution_ImplementStackusingQueues {

    public static class MyStack {

        Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            int size = queue.size();
            queue.add(x);

            for (int i = 0; i < size; ++i) {
                queue.offer(queue.poll());
            }
        }

        public int pop() throws Exception{
            if (!queue.isEmpty())
                return queue.poll();

            throw new Exception();
        }

        public int top() throws Exception {
            if (!queue.isEmpty())
                return queue.peek();

            throw new Exception();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(3);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
    }
}
