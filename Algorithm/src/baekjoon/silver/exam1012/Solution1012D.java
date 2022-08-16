package baekjoon.silver.exam1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1012. 유기농배추
 * 이다은
 */
public class Solution1012D {
    static int[][] visited;
    static int[][] field;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int m, n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            field = new int[n][m];
            visited = new int[n][m];
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(reader.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[y][x] = 1;
            }

            int answer = 0;
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if (visited[j][l] == 0 && field[j][l] == 1) {
                        dfs(j, l);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }
    }

    public static void dfs(int y, int x) {
        visited[y][x] = 1;

        if (field[y][x] == 1) {
            for (int i = 0; i < 4; i++) {
                if (y+dy[i] >= 0 && x+dx[i] >= 0 && y+dy[i] < n && x+dx[i] < m && visited[y+dy[i]][x+dx[i]] == 0) {
                    dfs(y+dy[i], x+dx[i]);
                }
            }
        }

    }
}
