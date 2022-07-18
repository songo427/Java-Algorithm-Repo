package sw.expert.academy.exam1979;

import java.util.Scanner;

/**
 * 1979. 어디에 단어가 들어갈 수 있을까
 * 송현주
 */
public class Solution1979H {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int count = 0;
            int n = sc.nextInt();
            int k = sc.nextInt();
            int answer = 0;
            int[][] puzzle = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    puzzle[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (puzzle[i][j] == 1)
                        count++;
                    else if (count > 0 && puzzle[i][j] == 0) {
                        if (count == k) answer++;
                        count = 0;
                    }
                }
                if (count == k) {
                    answer++;
                }
                count = 0;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (puzzle[j][i] == 1)
                        count++;
                    else if (count > 0 && puzzle[j][i] == 0) {
                        if (count == k) answer++;
                        count = 0;
                    }
                }
                if (count == k) {
                    answer++;
                }
                count = 0;
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }
}
