package sw.expert.academy.exam2005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2005. 파스칼의 삼각형
 * 송현주
 */

public class Solution2005H {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            StringBuilder answer = new StringBuilder("#" + tc + "\n");

            int[][] board = new int[N][N];

            if (N == 1) {
                board[0][0] = 1;
            } else {
                board[0][0] = 1;
                board[1][0] = 1;
                board[1][1] = 1;
            }
            for (int i = 2; i < N; i++) {
                board[i][0] = 1;
                board[i][i] = 1;
                for (int j = 1; j < N - 1; j++) {
                    board[i][j] = board[i - 1][j - 1] + board[i - 1][j];
                }
            }

            for (int[] line : board) {
                for (int i = 0; i < line.length; i++) {
                    if (line[i] != 0) answer.append(line[i] + " ");
                }
                answer.append("\n");
            }
            System.out.println(answer.toString().trim());
        }
    }
}