package sw.expert.academy.exam1954;

import java.util.Scanner;

/**
 * 1954. 달팽이 숫자 D2
 * 송현주
 **/

public class Solution1954H {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // testcase
        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {

            // 달팽이 크기 N (1-10)
            int N = sc.nextInt();
            int[][] board = new int[N][N];

            // 우 -> 하 -> 좌 -> 상
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};
            int idx = 0;

            // 달팽이 숫자
            int count = 2;

            int x = 0, y = 0;
            board[x][y] = 1;
            while (count < N * N + 1) {

                int nx = x + dx[idx];
                int ny = y + dy[idx];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || board[nx][ny] != 0) {
                    idx = (idx + 1) % 4;
                    nx = x + dx[idx];
                    ny = y + dy[idx];
                }

                board[nx][ny] = count++;
                x = nx;
                y = ny;
            }

            printBoard(testCase, board);
        }

    }
    public static void printBoard (int testCase, int[][]arr){
        System.out.println("#" + testCase);
        for(int[] line : arr){
            for(int num : line){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
