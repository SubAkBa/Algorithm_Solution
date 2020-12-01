import java.util.*;
import java.io.*;

public class Solution_10845 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        while((--N) >= 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String msg = st.nextToken();
            int result = Integer.MAX_VALUE;

            switch(msg){
                case "push":
                    deque.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    result = deque.isEmpty() ? -1 : deque.pollFirst();
                    break;
                case "size":
                    result = deque.size();
                    break;
                case "empty":
                    result = deque.isEmpty() ? 1 : 0;
                    break;
                case "front":
                    result = deque.isEmpty() ? -1 : deque.peekFirst();
                    break;
                case "back":
                    result = deque.isEmpty() ? -1 : deque.peekLast();
                    break;
            }

            if(result != Integer.MAX_VALUE)
                bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
