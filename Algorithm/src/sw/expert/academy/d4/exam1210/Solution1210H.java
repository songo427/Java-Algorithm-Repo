package sw.expert.academy.d4.exam1210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1210. [S/W 문제해결 기본] 2일차 - Ladder1
 * 송현주
 */

public class Solution1210H {

    static int[][] ladder;
    static boolean[][] visited;
    static int x, y;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int testCase = 1; testCase <= 10; testCase++) {

            Integer.parseInt(br.readLine());
            ladder = new int[100][100];
            visited = new boolean[100][100];
            y = 99;

            for (int i = 0; i < 100; i++) {
                String input = br.readLine();
                StringTokenizer tokenizer = new StringTokenizer(input, " ");
                for (int j = 0; j < 100; j++) {
                    ladder[i][j] = Integer.parseInt(tokenizer.nextToken());
                    if (ladder[i][j] == 2) {
                        x = j;
                    }
                }
            }

            System.out.println("#" + testCase + " " + climbLadder());

        }
    }

    private static int climbLadder() {
        while (y != 0) {

            // 왼쪽으로 이동 가능하다면,
            if (x - 1 > 0 && !visited[y][x - 1] && ladder[y][x - 1] == 1) {
                visited[y][x - 1] = true;
                x -= 1;

                // 오른쪽으로 이동 가능하다면,
            } else if (x + 1 < 100 && !visited[y][x + 1] && ladder[y][x + 1] == 1) {
                visited[y][x + 1] = true;
                x += 1;

                // 왼쪽, 오른쪽 이동이 불가능 하다면, 위로 이동
            } else {
                visited[y - 1][x] = true;
                y -= 1;
            }
        }
        return x;
    }
}
