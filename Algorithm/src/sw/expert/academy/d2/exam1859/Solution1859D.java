package sw.expert.academy.d2.exam1859;

import java.util.Scanner;

/**
 * 1859. 백만 장자 프로젝트
 * 이다은
 **/
public class Solution1859D {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scn.nextInt();
            long[] salePrice = new long[n];

            for (int j = 0; j < n; j++) {
                salePrice[j] = scn.nextInt();
            }

            long answer = 0;
            long max = 0;
            for (int j = n-1; j >= 0 ; j--) {
                if (max <= salePrice[j]) {
                    max = salePrice[j];
                } else {
                    answer += max - salePrice[j];
                }

            }

            System.out.println("#" + (i+1) + " " + answer);
        }

        scn.close();
    }
}
