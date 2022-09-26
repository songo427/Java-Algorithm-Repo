package baekjoon.gold.exam2573;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 2573. 빙산
 * 송현주
 */

public class Solution2573H {
    static int[][] iceberg;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N, M;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        iceberg = new int[N][M];

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                iceberg[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        int year=0;
        while(true){
            int cnt = 0;
            visited = new boolean[N][M];

            // 빙산 녹음
            iceberg = meltIceberg();
            year ++;

            // 현재 몇 개로 분리됐는지 확인
            for(int x=0; x<N; x++) {
                for(int y=0; y<M; y++) {
                    if(iceberg[x][y] == 0 || visited[x][y]) continue;
                    dfs(x, y);
                    cnt ++;
                }
            }

            // 빙산이 두 개 이상으로 분리됐다면
            if(cnt >= 2){
                break;
            }

            if(cnt == 0){
                year = 0;
                break;
            }
        }

        System.out.print(year);
    }

    // 4방 탐색 - 빙산 녹임
    private static int[][] meltIceberg() {
        int[][] meltedIceberg = new int[N][M];

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                // 녹은 높이
                int meltedHeight = 0;

                // 현재 칸이 이미 물이라면 탐색 하지 않음
                if (iceberg[x][y] == 0) continue;


                // 4방 탐색
                for (int i = 0; i < 4; i++) {
                    int nx = x + dir[i][0];
                    int ny = y + dir[i][1];

                    if (!isIn(nx, ny) || iceberg[nx][ny] != 0) continue;
                    meltedHeight++;
                }

                // 녹은 높이 만큼 감소
                meltedIceberg[x][y] = Math.max(iceberg[x][y] - meltedHeight, 0);
            }
        }
        return meltedIceberg;
    }

    // 현재 빙산이 몇 개인지 확인
    private static void dfs(int x, int y) {
        // 방문 확인
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if (!isIn(nx, ny) || iceberg[nx][ny] == 0) continue;
            if (!visited[nx][ny]) dfs(nx, ny);
        }
    }

    // 범위 확인
    private static boolean isIn(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < M;
    }
}
