package sw.expert.academy.exam1961;

import java.util.Scanner;

/**
 * 1961. 숫자 배열 회전
 * 송현주
 **/

public class Solution1961H {

    public static int[][] handleRotateArr(int[][] arr) {
        int length = arr.length;
        int[][] rotatedArr = new int[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                rotatedArr[i][j] = arr[length - j - 1][i];
            }
        }
        return rotatedArr;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[][] board = new int[n][n];
            int[][] rotation90, rotation180, rotation270;

            // board
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            // rotate
            rotation90 = handleRotateArr(board);
            rotation180 = handleRotateArr(rotation90);
            rotation270 = handleRotateArr(rotation180);


            // print
            System.out.println("#"+test_case);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(rotation90[i][j]);
                }
                System.out.print(" ");
                for (int j = 0; j < n; j++) {
                    System.out.print(rotation180[i][j]);
                }
                System.out.print(" ");
                for (int j = 0; j < n; j++) {
                    System.out.print(rotation270[i][j]);
                }

                System.out.print("\n");
            }
        }
    }

}
