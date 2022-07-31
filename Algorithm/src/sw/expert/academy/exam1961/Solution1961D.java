package sw.expert.academy.exam1961;

import java.util.Scanner;

/**
 * 1961. 숫자 배열 회전
 * 이다은
 */
public class Solution1961D {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = scn.nextInt();
            int[][] arr = new int[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    arr[j][k] = scn.nextInt();
                }
            }

            String[][] answer = new String[N][3];
            for (int j = 0; j < N; j++) {
                answer[j][0] = "";
                for (int k = 0; k < N; k++) {
                    answer[j][0] += arr[N-k-1][j];
                }
            }
            for (int j = 0; j < N; j++) {
                answer[j][1] = "";
                for (int k = 0; k < N; k++) {
                    answer[j][1] += arr[N-j-1][N-k-1];
                }
            }
            for (int j = 0; j < N; j++) {
                answer[j][2] = "";
                for (int k = 0; k < N; k++) {
                    answer[j][2] += arr[k][N-j-1];
                }
            }

            System.out.println("#" + i);
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 3; k++) {
                    System.out.print(answer[j][k] + " ");
                }
                System.out.println();
            }

        }
    }
}
