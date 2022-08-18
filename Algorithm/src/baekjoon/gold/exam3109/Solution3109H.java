package baekjoon.gold.exam3109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 3109. 빵집
 * 송현주
 */
public class Solution3109H {

    static int R, C, count, answer;
    // 우상, 우, 우하 이동
    static int[] dx = {-1, 0, 1};
    static int[] dy = {1, 1, 1};
    static boolean[][] visited; // 갈 수 있는지 체크
    static String[] picked;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer tokenizer = new StringTokenizer(input, " ");

        R = Integer.parseInt(tokenizer.nextToken()); // row
        C = Integer.parseInt(tokenizer.nextToken()); // column

        char[][] map = new char[R][C];
        visited = new boolean[R][C];
        picked = new String[10];
        count = 0;
        answer = 0;
        for (int i = 0; i < R; i++) {
            input = br.readLine();
            map[i] = input.toCharArray();

            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'x') {
                    visited[i][j] = true;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            if (!visited[i][0]) {
                if(search(i, 0)) answer++;
            }
        }
        System.out.print(answer);
    }

    private static boolean search(int x, int y) {

        visited[x][y] = true;

        if (y == C - 1) {
            //System.out.println();// 출력 확인용
            return true;
        }

        for (int i = 0; i < 3; i++) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 체크
            if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                if (!visited[nx][ny]) {
                    //System.out.println("(" + x + ", " + y+") => "+"(" + nx + ", " + ny+")"); // 출력 확인용
                    if(search(nx, ny)) return true;
                }
            }
        }
        return false;
    }
}
