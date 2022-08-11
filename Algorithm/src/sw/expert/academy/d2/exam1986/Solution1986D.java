package sw.expert.academy.d2.exam1986;

import java.util.Scanner;

/**
 * 1986. 지그재그 숫자
 * 이다은
 */
public class Solution1986D {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = scn.nextInt();
            if (N%2 == 0) {
                System.out.println("#" + i + " " + (-N/2));
            } else {
                System.out.println("#" + i + " " + (N/2 + 1));
            }
        }
    }
}
