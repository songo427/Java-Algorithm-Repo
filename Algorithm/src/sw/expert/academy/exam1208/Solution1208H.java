package sw.expert.academy.exam1208;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1208. [S/W 문제해결 기본] 1일차 - Flatten
 * 송현주
 */

public class Solution1208H {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int dumpCount = sc.nextInt();
            int[] board = new int[100];

            for (int i = 0; i < 100; i++) {
                board[i] = sc.nextInt();
            }

            Arrays.sort(board);
            int answer = 0;

            while (true) {
                if (dumpCount == 0 || board[99] - board[0] <= 1) {
                    answer = board[99] - board[0];
                    break;
                }

                if (board[0] <= board[1]) {
                    board[0] = board[0] + 1;
                    board[99] = board[99] - 1;
                    dumpCount--;
                    Arrays.sort(board);
                }
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}

