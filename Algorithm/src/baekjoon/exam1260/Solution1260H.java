package baekjoon.exam1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * 1260. DFS와 BFS
 * 송현주
 * */
public class Solution1260H {
    static int N, M; // N: 정점의 수, M: 간선의 수
    static StringBuilder answer;
    static int[][] graph; // [N+1][N+1] 크기의 배열

    static Queue<Integer> tmp; // BFS에 사용할 큐

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringTokenizer tokenizer = new StringTokenizer(input);
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        int V = Integer.parseInt(tokenizer.nextToken());


        graph = new int[N + 1][N + 1];
        boolean[] isVisited = new boolean[10001];

        // 인접 행렬 생성
        for (int i = 1; i <= M; i++) {
            input = br.readLine();
            tokenizer = new StringTokenizer(input, " ");
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            graph[x][y] = graph[y][x] = 1;
        }

        // DFS 출력
        answer = new StringBuilder();
        dfs(isVisited, V);
        System.out.println(answer);

        // BFS 출력
        answer = new StringBuilder();
        isVisited = new boolean[1001];
        tmp = new ArrayDeque<>();
        bfs(V, isVisited);
        System.out.print(answer);
    }

    /** DFS 구현부 **/
    private static void dfs(boolean[] isVisited, int v) {
        isVisited[v] = true;
        answer.append(v).append(" ");

        for (int i = 1; i <= N; i++) {
            if (!isVisited[i] && graph[v][i] == 1) {
                dfs(isVisited, i);
            }
        }
    }

    /** BFS 구현부 **/
    private static void bfs(int v, boolean[] isVisited) {

        tmp.add(v);
        isVisited[v] = true;

        while (!tmp.isEmpty()) {
            int curNum = tmp.poll();
            answer.append(curNum + " ");

            for (int i = 1; i <= N; i++) {
                if (graph[curNum][i] == 1 && !isVisited[i]) {
                    tmp.add(i);
                    isVisited[i] = true;
                }
            }
        }
    }
}