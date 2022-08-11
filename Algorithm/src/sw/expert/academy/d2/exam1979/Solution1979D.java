package sw.expert.academy.d2.exam1979;

import java.util.Scanner;

/**
 * 1979. 어디에 단어가 들어갈 수 있을까
 * 이다은
 */
public class Solution1979D {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = scn.nextInt();
            int K = scn.nextInt();
            int[][] board = new int[N][N];
            int answer = 0;
            int current = 0;

            // 입력받으면서 가로줄 확인
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    board[j][k] = scn.nextInt();
                    if (board[j][k] == 0) {
                        if (current == K) {
                            answer++;
                        }
                        current = 0;
                    } else {
                        current++;
                    }
                }

                if (current == K) {
                    answer++;
                }

                current = 0;
            }

            // 세로줄 확인
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (board[k][j] == 0) {
                        if (current == K) {
                            answer++;
                        }
                        current = 0;
                    } else {
                        current++;
                    }
                }

                if (current == K) {
                    answer++;
                }

                current = 0;
            }

            System.out.println("#" + i + " " + answer);
        }
    }
}
