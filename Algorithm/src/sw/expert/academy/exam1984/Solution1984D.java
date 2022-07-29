package sw.expert.academy.exam1984;

import java.util.Scanner;

/**
 * 1984. 중간 평균값 구하기 D2
 * 이다은
 */
public class Solution1984D {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();

        for (int i = 1; i <= T; i++) {
            int sum = scn.nextInt();
            int min = sum;
            int max = sum;
            for (int j = 0; j < 9; j++) {
                int num = scn.nextInt();
                sum += num;
                if (num < min) {
                    min = num;
                }
                if (num > max) {
                    max = num;
                }
            }
            System.out.println("#" + i + " " + Math.round(((float)sum - min - max)/8));
        }
    }
}
