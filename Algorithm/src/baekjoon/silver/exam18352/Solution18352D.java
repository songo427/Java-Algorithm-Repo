package baekjoon.silver.exam18352;

import java.io.*;
import java.util.*;

public class Solution18352D {
    static int N, M, K, X;
    static List<List<Integer>> graph;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start-1).add(end);
        }

        bfs();

        int cnt = 0;
        for (int i = 1; i < depth.length; i++) {
            if (depth[i] == K) {
                System.out.println(i);
                cnt++;
            }
        }

        if (cnt == 0) System.out.println(-1);
    }

    static void bfs() {
        Deque<Integer> queue = new ArrayDeque();
        boolean[] visited = new boolean[N+1];
        depth = new int[N+1];
        queue.add(X);
        visited[X] = true;

        while (!queue.isEmpty()) {
            int node = queue.pop();
            for (int child : graph.get(node-1)) {
                if (!visited[child]) {
                    queue.add(child);
                    depth[child] = depth[node] + 1;
                    visited[child] = true;
                }
            }
        }

    }
}
