package sw.expert.academy.exam1954;

import java.util.Scanner;

/**
 * 1954. 달팽이 숫자 D2
 * 이다은
 **/

public class Solution1954D {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int i = 0; i < t; i++) {
            int n = scn.nextInt();
            int idx = 0;
            int x = 0, y = 0;
            int[][] snail = new int[n][n];
            int cur = 1;
            while (cur <= n*n) {
                if (x < 0 || y < 0 || x == n || y == n) {
                    x -= direction[idx][0];
                    y -= direction[idx][1];
                    idx = (idx + 1) % 4;
                } else if (snail[x][y] != 0) {
                    x -= direction[idx][0];
                    y -= direction[idx][1];
                    idx = (idx + 1) % 4;
                } else {
                    snail[x][y] = cur;
                    cur++;
                }

                x += direction[idx][0];
                y += direction[idx][1];
            }

            System.out.println("#" + (i+1));
            for (int[] arr : snail) {
                for (int num : arr) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
    }
}
