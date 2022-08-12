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
    // 우 -> 상 -> 좌 -> 하 순으로 탐색
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int[][] array;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringTokenizer tokenizer = new StringTokenizer(input, " ");
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        R = Integer.parseInt(tokenizer.nextToken());
        count = Math.min(N, M) / 2;
        array = new int[N][M];

        // input
        for (int i = 0; i < N; i++) {
            input = br.readLine();
            tokenizer = new StringTokenizer(input, " ");
            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        // rotate array
        int rotateCount = 0;
        while (rotateCount < R) {
            rotateArray(count);
            rotateCount++;
        }
        printArr(array);
    }

    private static void rotateArray(int rotateCount) {

        // 탐색하는 라인에 따라 범위가 달라짐 -> m과 n을 따로 저장
        int m = M;
        int n = N;
        int curLine = 0;

        while (curLine < rotateCount) {

            int x = curLine;
            int y = curLine;

            int idx = 1; // 탐색할 수의 개수
            int dir = 0; // dx, dy의 방향을 바꾸기 위한 변수
            int first = array[x][y];
            int loop = (m + n - 2) * 2;

            while (idx < loop + 1) {

                int nx = x + dx[dir];
                int ny = y + dy[dir];

                // 범위를 벗어나는 경우 체크
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

            // 탐색할 크기 조정
            m -= 2;
            n -= 2;

            // 첫번째 요소 저장
            array[curLine + 1][curLine] = first;
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
