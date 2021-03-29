import java.util.*;
import java.io.*;

public class Solution_16500 {
    static int SIZE = 26;

    public static class TrieNode {
        TrieNode[] children;
        boolean isEndofWords;

        public TrieNode() {
            this.children = new TrieNode[SIZE];
            this.isEndofWords = false;
        }
    }

    public static class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void Insert(String str) {
            TrieNode temp = root;
            int len = str.length();

            for (int i = 0; i < len; ++i) {
                int idx = str.charAt(i) - 'a';

                if (temp.children[idx] == null)
                    temp.children[idx] = new TrieNode();

                temp = temp.children[idx];
            }

            temp.isEndofWords = true;
        }
    }

    public static void Search(Trie trie, TrieNode current, String str, int idx, boolean[] visited) {
        if (idx == str.length())
            return;

        TrieNode temp = current.children[str.charAt(idx) - 'a'];

        if (temp == null)
            return;

        if (!visited[idx] && temp.isEndofWords) {
            visited[idx] = true;
            Search(trie, trie.root, str, idx + 1, visited);
        }

        Search(trie, temp, str, idx + 1, visited);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());
        Trie trie = new Trie();

        for (int i = 0; i < N; ++i)
            trie.Insert(br.readLine());

        int len = str.length();
        boolean[] visited = new boolean[len];
        Search(trie, trie.root, str, 0, visited);

        bw.write((visited[len - 1] ? 1 : 0) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
