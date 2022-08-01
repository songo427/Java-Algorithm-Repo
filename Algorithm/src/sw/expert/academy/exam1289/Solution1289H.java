package sw.expert.academy.exam1289;

import java.util.Scanner;

/**
 * 1289. 원재의 메모리 복구하기 
 * 송현주
 */

public class Solution1289H {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            String target = sc.next();
            int length = target.length();

            char curChar = '0';
            int answer = 0;
            for (int i = 0; i < length; i++) {
                if (target.charAt(i) != curChar) {
                    curChar = target.charAt(i);
                    answer++;
                }
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }
}
