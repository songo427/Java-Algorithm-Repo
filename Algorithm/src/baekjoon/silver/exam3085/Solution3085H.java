package baekjoon.silver.exam3085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 3085.사탕 게임
 * 송현주
 */
public class Solution3085H {
    static char[][] board;
    // 상 하 좌 우
    static int[][] deltaXY = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N, maxCount;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        maxCount = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            board[i] = line.toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                search(i, j);
            }
            if (maxCount == N) break;
        }
        System.out.print(maxCount);
    }

    // 4방 탐색 - 인접한 사탕의 색이 다르다면 swap
    private static void search(int x, int y) {

        for (int i = 0; i < 4; i++) {

            int nx = x + deltaXY[i][0];
            int ny = y + deltaXY[i][1];

            // 범위를 벗어났거나 인접한 곳에 사탕 색이 같다면, continue
            if (!isIn(nx, ny) || board[x][y] == board[nx][ny]) continue;

            // swap
            swapCandy(x, y, nx, ny);
            findMaxLine();
            swapCandy(x, y, nx, ny);
        }
    }

    // 범위 확인
    private static boolean isIn(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < N;
    }

    // 인접한 사탕 교체
    private static void swapCandy(int x, int y, int nx, int ny) {
        char tmp = board[x][y];
        board[x][y] = board[nx][ny];
        board[nx][ny] = tmp;
    }

    // 가장 긴 연속된 부분 찾기(행/열)
    private static void findMaxLine() {

        for (int i = 0; i < N; i++) {

            if (maxCount == N) return;

            int rowCnt = 1;
            for (int j = 1; j < N; j++) {
                rowCnt = board[i][j - 1] != board[i][j] ? 1 : rowCnt + 1;
                maxCount = Math.max(rowCnt, maxCount);
            }

            int columnCnt = 1;
            for (int j = 1; j < N; j++) {
                columnCnt = board[j - 1][i] != board[j][i] ? 1 : columnCnt + 1;
                maxCount = Math.max(columnCnt, maxCount);
            }
        }
    }
}
