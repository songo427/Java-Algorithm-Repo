package baekjoon.silver.exam2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2606. 바이러스
 * 이다은
 */
public class Solution2606D {
    static int[][] graph;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int edge_n = Integer.parseInt(reader.readLine());
        graph = new int[n+1][n+1];
        visited = new int[n+1];

        for (int i = 0; i < edge_n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        dfs(1);

        int answer = 0;
        for (int v : visited) {
            answer += v;
        }
        System.out.println(answer - 1);
    }

    public static void dfs(int v) {
        visited[v] = 1;
        for (int i = 1; i < graph[v].length; i++) {
            if (graph[v][i] == 1 && visited[i] == 0) {
                dfs(i);
            }
        }
    }
}
