package baekjoon.silver.exam2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2606. 바이러스
 * 송현주
 */
public class Solution2606H {

    static int N, computerCount;
    static int[][] network;
    static int answer;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        computerCount = Integer.parseInt(br.readLine().trim());
        N = Integer.parseInt(br.readLine().trim());
        network = new int[computerCount + 1][computerCount + 1];
        boolean[] visited = new boolean[computerCount+ 1];
        answer = 0;

        // input
        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            StringTokenizer tokenizer = new StringTokenizer(input);
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            network[x][y] = 1;
            network[y][x] = 1;
        }

        dfs(visited, 1);
        System.out.print(answer);
    }

    private static void dfs(boolean[] visited, int v) {

        visited[v] = true;

        for (int i = 1; i <= computerCount; i++) {
            if (!visited[i] && network[v][i] == 1) {
                answer++;
                dfs(visited, i);
            }
        }

    }
}

