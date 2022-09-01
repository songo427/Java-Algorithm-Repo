package baekjoon.silver.exam2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2443. 촌수계산
 * 송현주
 */
public class Solution2644H {
    static int N, end, answer;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 총 N명
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        int M = Integer.parseInt(br.readLine()); // M 개의 관계
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from][to] = 1;
            graph[to][from] = 1;
        }
        System.out.print(dfs(start, 0) ? answer : -1);
    }

    private static boolean dfs(int start, int cnt) {

        visited[start] = true;

        // 촌수가 존재하다면 리턴
        if (visited[end]) {
            answer = cnt;
            return true;
        }

        // 탐색
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && graph[start][i] == 1) {
                if(dfs(i, cnt + 1)) return true;
            }
        }
        return false;
    }

    private static void print(int[][] arr) {
        for (int[] line : arr) {
            for (int num : line) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
