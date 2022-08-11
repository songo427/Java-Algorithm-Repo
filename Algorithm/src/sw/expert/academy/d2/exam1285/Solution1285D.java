package sw.expert.academy.d2.exam1285;

import java.util.Scanner;

/**
 * 1285. 아름이의 돌던지기 D2
 * 이다은
 **/
public class Solution1285D {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scn.nextInt();

            int min = 100001;
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                int loc = scn.nextInt();
                if (min > Math.abs(loc)) {
                    min = Math.abs(loc);
                    cnt = 1;
                } else if (min == Math.abs(loc)) {
                    cnt++;
                }
            }

            System.out.println("#" + (i+1) + " " + min + " " + cnt);

        }
    }
}
