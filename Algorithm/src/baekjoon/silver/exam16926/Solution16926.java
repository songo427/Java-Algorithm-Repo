package baekjoon.silver.exam16926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 16926. 배열 돌리기 1
 * 송현주
 * */
public class Solution16926 {

    static int N, M, R, count;
    // 우 -> 상 -> 좌 -> 하
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int[][] array;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        StringTokenizer tokenizer = new StringTokenizer(line, " ");
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        R = Integer.parseInt(tokenizer.nextToken());
        count = Math.min(N, M) / 2;

        array = new int[N][M];
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            tokenizer = new StringTokenizer(line, " ");
            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

//        System.out.println("원본");
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(array[i][j] + "\t");
//            }
//            System.out.println();
//        }
//        System.out.println("===================");

        int lineCount = 0;
        while (lineCount < R) {
            rotateArray(count);
            lineCount++;
        }
        printArr(array);
    }

    private static void rotateArray(int lineCount) {

        int m = M;
        int n = N;
        int curLine = 0;
        while (curLine < lineCount) {
            int x = curLine; // 0
            int y = curLine; // 0

            int idx = 1;
            int dir = 0;
            int tmp = array[x][y];

            int loop = (m + n - 2) * 2;

            while (idx < loop + 1) {

                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < curLine || ny < curLine || nx >= N - curLine || ny >= M - curLine) {
                    dir = (dir + 1) % 4;
                    nx = x + dx[dir];
                    ny = y + dy[dir];
                }

                array[x][y] = array[nx][ny];
                x = nx;
                y = ny;
                idx++;
            }

            m -= 2;
            n -= 2;
            array[curLine + 1][curLine] = tmp;
            curLine++;

        }
    }

    private static void printArr(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
