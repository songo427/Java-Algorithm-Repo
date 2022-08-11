package sw.expert.academy.d2.exam2005;

import java.util.Scanner;

/**
 * 2005. 파스칼의 삼각형
 * 이다은
 */
public class Solution2005D {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = scn.nextInt();
            int[][] arr = new int[10][10];

            arr[0][0] = 1;
            arr[1][0] = 1;
            arr[1][1] = 1;

            for (int j = 2; j < N; j++) {
                arr[j][0] = 1;
                arr[j][j] = 1;
                for (int k = 1; k < j; k++) {
                    arr[j][k] = arr[j-1][k-1] + arr[j-1][k];
                }
            }

            System.out.println("#" + i);
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < j+1; k++) {
                    System.out.print(arr[j][k] + " ");
                }
                System.out.println();
            }
        }
    }
}
