package baekjoon.gold.exam13023;

import java.io.*;
import java.util.*;

public class Solution13023D {
    static int N;
    static ArrayList<Integer>[] rel;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        rel = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            rel[i] = new ArrayList<>();
        }

        // 인접리스트 만들기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            rel[a].add(b);
            rel[b].add(a);
        }

        // 모든 노드를 탐색하면서 루트 노드 변경해보기
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            dfs(i, 1);
            if (answer == 1) break;
        }

        System.out.println(answer);
    }

    public static void dfs(int v, int depth) {
        visited[v] = true;

        for (int node : rel[v]) {
            if (depth == 4) {
                answer = 1;
                return;
            }

            if (!visited[node]) {
                dfs(node, depth + 1);
            }
        }

        // 방문했던 노드 삭제
        visited[v] = false;

    }
}
