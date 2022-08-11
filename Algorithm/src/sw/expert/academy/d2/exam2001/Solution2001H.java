package sw.expert.academy.d2.exam2001;
import java.util.Scanner;

/**
 * 2001. 파리 퇴치
 * 송현주
 **/

public class Solution2001H {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] board = new int[n][n];
            int sum = 0, maxSum = 0;

            // board 판
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            // 합 계산 및 maxSum 설정
            for (int i = 0; i < n - m + 1; i++) {
                for (int j = 0; j < n - m + 1; j++) {
                    sum = 0;
                    for (int k = 0; k < m; k++) {
                        for (int l = 0; l < m; l++) {
                            sum += board[i + k][j + l];
                        }
                    }
                    if (maxSum < sum) {
                        maxSum = sum;
                    }
                }
            }
            System.out.println("#" + test_case + " " + maxSum);
        }
    }
}
