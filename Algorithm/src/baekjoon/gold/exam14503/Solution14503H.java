package baekjoon.gold.exam14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 14503. 로봇 청소기
 * 송현주
 */
public class Solution14503H {

    // 북 - 동 - 남 - 서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M, D, answer;
    static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringTokenizer tokenizer = new StringTokenizer(input, " ");

        answer = 1;
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        map = new int[N][M];

        input = br.readLine();
        tokenizer = new StringTokenizer(input, " ");
        int r = Integer.parseInt(tokenizer.nextToken());
        int c = Integer.parseInt(tokenizer.nextToken());
        D = Integer.parseInt(tokenizer.nextToken()); // 청소기가 보는 방향

        // 맵 생성
        for (int i = 0; i < N; i++) {
            input = br.readLine();
            tokenizer = new StringTokenizer(input, " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        cleanRoom(r, c, D);
        System.out.print(answer);
    }

    private static void cleanRoom(int x, int y, int dir) {

        // 현재 위치 청소(청소 완료 == 2)
        map[x][y] = 2;

        // 북-동-남-서 4방탐색
        for (int i = 0; i < 4; i++) {

            // 현재 방향 기준 왼쪽 방향 설정
            dir = (dir + 3) % 4;

            // 청소 방향의 위치 설정
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 청소할 수 있는 위치라면 청소 (청소한 곳은 다시 청소 하지 않음)
            if (isIn(nx, ny) && map[nx][ny] == 0) {
                answer++;
                cleanRoom(nx, ny, dir);
                return;
            }
        }

        // 4방향 모두 청소 후 갈 곳이 없다면, 후진 방향 설정
        int nx = x + dx[(dir + 2) % 4];
        int ny = y + dy[(dir + 2) % 4];

        // 벽이 아니라면 후진
        if (isIn(nx, ny) && map[nx][ny] != 1) {
            cleanRoom(nx, ny, dir);
        }
    }

    // 청소할 수 있는 영역인지 확인
    private static boolean isIn(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }
}
