import java.util.*;
import java.io.*;

public class Solution_9250 {
    static int SIZE = 26;

    public static class TrieNode {
        TrieNode[] children;
        TrieNode fail;
        boolean isEndOfWords;
        boolean isRoot;

        public TrieNode(boolean isRoot) {
            this.children = new TrieNode[SIZE];
            this.isEndOfWords = false;
            this.isRoot = isRoot;
        }
    }

    public static class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode(true);
        }

        public void Insert(String str) {
            TrieNode temp = this.root;
            int len = str.length();

            for (int i = 0; i < len; ++i) {
                int idx = str.charAt(i) - 'a';

                if (temp.children[idx] == null)
                    temp.children[idx] = new TrieNode(false);

                temp = temp.children[idx];
            }

            temp.isEndOfWords = true;
        }

        public void Failure() {
            Queue<TrieNode> queue = new LinkedList<>();
            this.root.fail = this.root;
            queue.offer(this.root);

            while (!queue.isEmpty()) {
                TrieNode current = queue.poll();

                for (int i = 0; i < SIZE; ++i) {
                    TrieNode next = current.children[i];

                    if (next == null)
                        continue;

                    if (current.isRoot)
                        next.fail = this.root;
                    else {
                        TrieNode failure = current.fail;

                        while (!failure.isRoot && failure.children[i] == null)
                            failure = failure.fail;

                        if (failure.children[i] != null)
                            failure = failure.children[i];

                        next.fail = failure;
                    }

                    if (next.fail.isEndOfWords)
                        next.isEndOfWords = true;

                    queue.offer(next);
                }
            }
        }

        public boolean Query(String str) {
            TrieNode temp = root;
            int len = str.length();

            for (int i = 0; i < len; ++i) {
                int idx = str.charAt(i) - 'a';

                while (!temp.isRoot && temp.children[idx] == null)
                    temp = temp.fail;

                if (temp.children[idx] != null)
                    temp = temp.children[idx];

                if (temp.isEndOfWords)
                    return true;
            }

            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Trie trie = new Trie();
        for (int i = 0; i < N; ++i)
            trie.Insert(br.readLine());

        trie.Failure();

        int Q = Integer.parseInt(br.readLine());
        while ((--Q) >= 0) {
            if (trie.Query(br.readLine()))
                bw.write("YES\n");
            else
                bw.write("NO\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
