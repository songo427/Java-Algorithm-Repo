package sw.expert.academy.exam1989;

import java.util.Scanner;

/**
 * 1989. 초심자의 회문 검사 D2
 * 이다은
 **/
public class Solution1989D {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        for (int i = 1; i <= t; i++) {
            StringBuilder sb = new StringBuilder(scn.next());

            if (sb.toString().equals(sb.reverse().toString())) {
                System.out.println("#" + i + " 1");
            } else {
                System.out.println("#" + i + " 0");
            }
        }
    }
}
