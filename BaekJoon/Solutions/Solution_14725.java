import java.util.*;
import java.io.*;

public class Solution_14725 {
    static StringBuilder sb;

    public static class Node {
        TreeMap<String, Node> child;

        public Node() {
            this.child = new TreeMap<>();
        }
    }

    public static void Insert(Node node, String[] path, int idx) {
        if (idx == path.length)
            return;

        if (!node.child.containsKey(path[idx]))
            node.child.put(path[idx], new Node());

        Insert(node.child.get(path[idx]), path, idx + 1);
    }

    public static void DFS(Node node, int depth) {
        for (String key : node.child.keySet()) {
            for (int i = 0; i < depth; ++i)
                sb.append("--");
            sb.append(key + "\n");

            DFS(node.child.get(key), depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        Node root = new Node();
        sb = new StringBuilder();

        while ((--N) >= 0) {
            st = new StringTokenizer(br.readLine());

            int K = Integer.parseInt(st.nextToken());
            String[] path = new String[K];
            for (int i = 0; i < K; ++i)
                path[i] = st.nextToken();

            Insert(root, path, 0);
        }

        DFS(root, 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
