package sw.expert.academy.exam1974;

import java.util.Scanner;

/**
 * 1974. 스도쿠 검증
 * 송현주
 */

public class Solution1974H {
    public static boolean handleCheckRow(int[][] sudoku) {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sum += sudoku[i][j];
            }
            if (sum != 45) {
                return true;
            }
            sum = 0;
        }
        return false;
    }

    public static boolean handleCheckColumn(int[][] sudoku) {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sum += sudoku[j][i];
            }
            if (sum != 45) {
                return true;
            }
            sum = 0;
        }
        return false;
    }

    public static boolean handleCheckGrid(int[][] sudoku) {
        int sum = 0;
        for (int i = 0; i < 9; i += 3) {
            for (int m = 0; m < 9; m += 3) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        sum += sudoku[i + j][m + k];
                    }
                }
                if (sum != 45) {
                    return true;
                }
                sum = 0;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int[][] sudoku = new int[9][9];
            boolean isDuplicated = false;
            // 스도쿠 생성
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sudoku[i][j] = sc.nextInt();
                }
            }

            while (true) {
                if (isDuplicated) break;
                if (handleCheckRow(sudoku)) {
                    isDuplicated = true;
                    System.out.println("#" + test_case + " 0");
                } else {
                    if (handleCheckColumn(sudoku)) {
                        isDuplicated = true;
                        System.out.println("#" + test_case + " 0");
                    } else {
                        if (handleCheckGrid(sudoku)) {
                            isDuplicated = true;
                            System.out.println("#" + test_case + " 0");
                        } else {
                            System.out.println("#" + test_case + " 1");
                            break;
                        }
                    }
                }

            }
        }
    }
}