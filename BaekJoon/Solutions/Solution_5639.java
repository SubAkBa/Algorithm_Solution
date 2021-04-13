import java.io.*;

public class Solution_5639 {
    static StringBuilder sb;

    public static class Node {
        Node left, right;
        int value;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static class Tree {
        Node root;

        public Tree(int value) {
            this.root = new Node(value);
        }

        public void Insert(Node temp, int value) {
            if (temp.value > value) {
                if (temp.left == null)
                    temp.left = new Node(value);
                else
                    Insert(temp.left, value);
            } else {
                if (temp.right == null)
                    temp.right = new Node(value);
                else
                    Insert(temp.right, value);
            }
        }
    }

    public static void PostOrder(Node temp) {
        if (temp.left != null)
            PostOrder(temp.left);

        if (temp.right != null)
            PostOrder(temp.right);

        sb.append(temp.value + "\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Tree tree = new Tree(Integer.parseInt(br.readLine()));
        String n = "";
        sb = new StringBuilder();

        while ((n = br.readLine()) != null)
            tree.Insert(tree.root, Integer.parseInt(n));

        PostOrder(tree.root);

        bw.write(sb.toString() + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
