import java.util.*;

public class Solution_SearchSuggestionsSystem {
    static final int ALPHABET_SIZE = 26;

    public static class TrieNode {
        TrieNode[] children;
        boolean isTerminal;

        public TrieNode() {
            this.children = new TrieNode[ALPHABET_SIZE];
            this.isTerminal = false;
        }
    }

    public static class Trie {
        TrieNode root;
        List<String> result;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode temp = root;
            int wLen = word.length();

            for (int i = 0; i < wLen; ++i) {
                int idx = word.charAt(i) - 'a';

                if (temp.children[idx] == null)
                    temp.children[idx] = new TrieNode();

                temp = temp.children[idx];
            }

            temp.isTerminal = true;
        }

        public List<String> getFoundList(String prefix) {
            result = new ArrayList<>();

            TrieNode cur = root;
            int pLen = prefix.length();

            for (int i = 0; i < pLen; ++i) {
                if (cur.children[prefix.charAt(i) - 'a'] == null)
                    return result;

                cur = cur.children[prefix.charAt(i) - 'a'];
            }
            DFS(cur, prefix);

            return result;
        }

        public void DFS(TrieNode cur, String prefix) {
            if (result.size() >= 3) {
                return;
            }

            if (cur.isTerminal) {
                result.add(prefix);
            }

            for (int i = 0; i < ALPHABET_SIZE; ++i) {
                if (cur.children[i] != null)
                    DFS(cur.children[i], prefix + (char)(i + 'a'));
            }
        }
    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        int wLen = searchWord.length();
        List<List<String>> answer = new ArrayList<>();

        Trie trie = new Trie();

        for (String product : products) {
            trie.insert(product);
        }

        for (int i = 0; i < wLen; ++i) {
            answer.add(trie.getFoundList(searchWord.substring(0, i + 1)));
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"}, "mouse"));
        System.out.println(suggestedProducts(new String[]{"havana"}, "havana"));
        System.out.println(suggestedProducts(new String[]{"bags","baggage","banner","box","cloths"}, "bags"));
    }
}
