package sw.expert.academy.d2.exam1986;

import java.util.Scanner;

/**
 * 1986. 지그재그 숫자
 * 송현주
 */

public class Solution1986H {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            int N = sc.nextInt();
            int sum = 0;
            for (int i = 1; i <= N; i++) {
                sum += i % 2 == 1 ? i : -i;
            }

            System.out.printf("#%d %d %n", test_case, sum);

        }
    }
}
