package baekjoon.gold.exam14725;

import java.io.*;
import java.util.*;

public class Solution14725D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Trie trie = new Trie();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            trie.insert(st);
        }

        trie.root.printNode(0);

        br.close();
    }

    static class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void insert(StringTokenizer st) {
            TrieNode node = root;
            while (st.hasMoreTokens()) {
                String text = st.nextToken();
                node = node.getChildren().computeIfAbsent(text, k -> new TrieNode());
            }
            node.setEndOfWord(true);
        }

    }
    static class TrieNode {
        Map<String, TrieNode> children = new HashMap<String, TrieNode>();
        boolean isEndOfWord;

        public Map<String, TrieNode> getChildren() {
            return children;
        }

        public void setEndOfWord(boolean endOfWord) {
            isEndOfWord = endOfWord;
        }

        public void printNode(int depth) {
            StringBuilder branch = new StringBuilder();
            for (int i = 0; i < depth; i++) {
                branch.append("--");
            }

            List<String> keySet = new ArrayList<>(children.keySet());
            Collections.sort(keySet);
            for (String key : keySet) {
                System.out.println(branch + key);
                children.get(key).printNode(depth + 1);
            }
        }
    }
}
