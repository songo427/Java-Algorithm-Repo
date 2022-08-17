package baekjoon.silver.exam2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 2630. 색종이 만들기
 * 송현주
 */
public class Solution2630H {
    static int white, blue, N;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(input[j]);
            }
        }

        splitPaper(N, 0, 0);

        answer.append(white + "\n");
        answer.append(blue);
        System.out.print(answer);
    }

    private static void splitPaper(int size, int row, int column) {
        if (isOneColor(size, row, column)) {
            return;
        }

        int halfSize = size / 2;
        splitPaper(halfSize, row, column);
        splitPaper(halfSize, row, column + halfSize);
        splitPaper(halfSize, row + halfSize, column);
        splitPaper(halfSize, row + halfSize, column + halfSize);
    }

    private static boolean isOneColor(int size, int row, int column) {
        int sum = 0;
        for (int x = row; x < size + row; x++) {
            for (int y = column; y < size + column; y++) {
                sum += paper[x][y];
            }
        }

        if (sum == 0) {
            white++;
            return true;
        } else if (sum == Math.pow(size, 2)) {
            blue++;
            return true;
        } else {
            return false;
        }
    }
}
