package baekjoon.gold.exam1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1987. 알파벳
 * 송현주
 */
public class Solution1987H {

    // 상 하 좌 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[] visited;
    static int[][] board;

    static int R, C, answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer tokenizer = new StringTokenizer(input, " ");

        visited = new boolean[26];
        R = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());

        board = new int[R + 1][C + 1];

        for (int i = 1; i <= R; i++) {
            input = br.readLine();
            char[] line = input.toCharArray();
            for (int j = 1; j <= C; j++) {
                board[i][j] = line[j - 1] - 'A';
            }
        }

        answer = 1;
        visited[board[1][1]] = true;
        search(1, 1, 1);
        System.out.print(answer);
    }

    private static void search(int x, int y, int cnt) {

        // 상 하 좌 우 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 체크
            if (isIn(nx, ny) && !visited[board[nx][ny]]) {
                visited[board[nx][ny]] = true;
                search(nx, ny, cnt +1);
                visited[board[nx][ny]] = false;
            }

        }

        // 더 이상 갈 곳이 없다면, 카운트 비교
        if (answer < cnt) {
            answer = cnt;
            return;
        }
    }

    private static boolean isIn(int nx, int ny) {
        return (nx > 0 && ny > 0 && nx <= R && ny <= C);
    }
}
