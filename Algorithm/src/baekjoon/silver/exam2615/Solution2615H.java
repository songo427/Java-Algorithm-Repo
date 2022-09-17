package baekjoon.silver.exam2615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2615. 오목
 * 송현주
 */
public class Solution2615H {

    static int[][] board;
    static int[][] dir = {{0, 1}, {1, 0}, {1, 1}, {1, -1}}; // 우 - 하  - 우하 - 좌하
    static StringBuilder answer;

    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = new StringBuilder();

        board = new int[19][19];
        for (int line = 0; line < 19; line++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < 19; i++) {
                board[line][i] = Integer.parseInt(st.nextToken());
            }
        }

        // 게임 시작! - 모든 경우 탐색
        loop:
        for (int x = 0; x < 19; x++) {
            for (int y = 0; y < 19; y++) {
                if (board[x][y] == 0) continue;
                if (playGame(x, y)) break loop;
            }
        }
        System.out.println(answer.length() == 0 ? "0" : answer);
    }

    private static boolean playGame(int x, int y) {

        // 현재 바둑돌 색 저장
        int current = board[x][y];

        // 방향 탐색
        for (int idx = 0; idx < 4; idx++) {

            // 탐색 방향 설정
            int nx = x + dir[idx][0];
            int ny = y + dir[idx][1];

            // 탐색 가능한지 확인 (범위 + 같은 색인지)
            if (!isIn(nx, ny) || board[nx][ny] != current) continue;

            // 게임 승부가 결정 됐다면
            if (search(nx, ny, current, idx)) {

                // 이전 바둑돌 확인
                int prevX = x - dir[idx][0];
                int prevY = y - dir[idx][1];

                if (!isIn(prevX, prevY) || board[prevX][prevY] != current) {

                    if (idx == 3) {
                        answer.append(board[x + 4][y - 4]).append("\n");
                        answer.append(x + 5).append(" ").append(y - 3);
                    } else {
                        answer.append(board[x][y]).append("\n");
                        answer.append(x + 1).append(" ").append(y + 1);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    // 탐색
    private static boolean search(int x, int y, int current, int idx) {

        int cnt = 2;
        while (true) {

            int nx = x + dir[idx][0];
            int ny = y + dir[idx][1];

            if (cnt == 5) {

                // 다음 위치의 바둑돌 확인
                if (!isIn(nx, ny) || board[nx][ny] != current) {
                    return true;
                }
                return false;
            }

            if (!isIn(nx, ny) || board[nx][ny] != current) return false;

            cnt++;
            x = nx;
            y = ny;
        }
    }

    private static boolean isIn(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < 19 && ny < 19;
    }
}
