package sw.expert.academy.d2.exam1974;

import java.util.Scanner;

/**
 * 1974. 스도쿠 검증
 * 이다은
 */
public class Solution1974D {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();

        for (int i = 1; i <= T; i++) {
            int[][] board = new int[9][9];

            // 스도쿠 판 입력받기
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    board[j][k] = scn.nextInt();
                }
            }

            int answer = 1;
            // 검증
            // 1) 가로줄
            for (int j = 0; j < 9; j++) {
                int product = 1;
                for (int k = 0; k < 9; k++) {
                    product *= board[j][k];
                }
                if (product != 362880) {
                    answer = 0;
                    break;
                }
            }

            if (answer == 1) {
                // 2) 세로줄
                for (int j = 0; j < 9; j++) {
                    int product = 1;
                    for (int k = 0; k < 9; k++) {
                        product *= board[k][j];
                    }
                    if (product != 362880) {
                        answer = 0;
                        break;
                    }
                }
            }

            // 3) 3x3 박스
            for (int j = 0; j < 3; j = j+3) {
                if (answer == 1) {
                    for (int k = 0; k < 3; k = k+3) {
                        int product = 1;
                        for (int l = 0; l < 3; l++) {
                            for (int m = 0; m < 3; m++) {
                                product *= board[j+l][k+m];
                            }
                        }
                        if (product != 362880) {
                            answer = 0;
                            break;
                        }
                    }
                }
            }

            System.out.println("#" + i + " " + answer);
        }

    }
}
