package baekjoon.exam1260;

import java.io.*;
import java.util.*;

/**
 * 1260. DFS와 BFS
 * 이다은
 */
public class Solution1260D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        Node[] tree = new Node[n+1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new Node(i);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].nodes.add(tree[b]);
            tree[b].nodes.add(tree[a]);
        }

        for (Node node : tree) {
            if (node != null) {
                Collections.sort(node.nodes);
            }
        }

        dfs(tree[v], new ArrayList<>());
        System.out.println();
        bfs(tree[v]);

    }

    public static void dfs(Node node, ArrayList<Integer> visited) {
        visited.add(node.data);
        System.out.print(node.data + " ");

        for (Node n : node.nodes) {
            if (!visited.contains(n.data)) {
                dfs(n, visited);
            }
        }

    }

    public static void bfs(Node node) {
        ArrayList<Integer> visited = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            node = queue.poll();
            if (!visited.contains(node.data)) {
                visited.add(node.data);
                System.out.print(node.data + " ");
                for (Node n : node.nodes) {
                    queue.offer(n);
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int data;
        ArrayList<Node> nodes;

        public Node(int data) {
            this.data = data;
            this.nodes = new ArrayList<>();
        }

        @Override
        public int compareTo(Node o) {
            return this.data - o.data;
        }
    }
}
