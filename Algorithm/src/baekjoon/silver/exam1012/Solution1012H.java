package baekjoon.silver.exam1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1012. 유기농 배추
 * 송현주
 */
public class Solution1012H {
    private static boolean[][] visited;
    private static int[][] farm;
    private static int answer, N, M, K;

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            String input = br.readLine();
            StringTokenizer tokenizer = new StringTokenizer(input);
            N = Integer.parseInt(tokenizer.nextToken());
            M = Integer.parseInt(tokenizer.nextToken());
            K = Integer.parseInt(tokenizer.nextToken());
            answer = 0;
            visited = new boolean[N + 1][M + 1];
            farm = new int[N + 1][M + 1];

            for (int i = 0; i < K; i++) {
                input = br.readLine();
                tokenizer = new StringTokenizer(input);
                int x = Integer.parseInt(tokenizer.nextToken());
                int y = Integer.parseInt(tokenizer.nextToken());
                farm[x][y] = 1;
            }

            // 탐색
            for (int x = 0; x <= N; x++) {
                for (int y = 0; y <= M; y++) {

                    // 현재 위치에 배추가 존재하고 아직 탐색하지 않았다면,
                    if (!visited[x][y] && farm[x][y] == 1) {
                        visited[x][y] = true;
                        search(visited, x, y);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }

    private static void search(boolean[][] visited, int x, int y) {
        // 4방 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx <= N && ny <= M) {

                // 탐색되지 않은 위치라면, 해당 조건을 기준으로 다시 4방 탐색
                if (farm[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    search(visited, nx, ny);
                }
            }
        }
    }
}