package sw.expert.academy.d2.exam2001;

import java.util.Scanner;

/**
 * 2001. 파리 퇴치
 * 이다은
 **/

public class Solution2001D {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scn.nextInt();
            int m = scn.nextInt();

            int[][] flies = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    flies[j][k] = scn.nextInt();
                }
            }

            int max_sum = 0;
            for (int j = 0; j < n-m+1; j++) {
                for (int k = 0; k < n-m+1; k++) {
                    int sum = 0;
                    for (int l = 0; l < m; l++) {
                        for (int o = 0; o < m; o++) {
                            sum += flies[j+l][k+o];
                        }
                    }
                    if (max_sum < sum) {
                        max_sum = sum;
                    }
                }
            }

            System.out.println("#" + (i+1) + " " + max_sum);

        }
    }
}
