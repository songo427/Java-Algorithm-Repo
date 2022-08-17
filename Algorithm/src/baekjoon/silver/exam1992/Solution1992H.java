package baekjoon.silver.exam1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 1992. 쿼드트리
 * 송현주
 */
public class Solution1992H {
    static int[][] data;
    static int N;
    static StringBuilder answer;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        data = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 1; j <= N; j++) {
                data[i][j] = Integer.parseInt(input[j - 1]);
            }
        }

        find(N, 1, 1);
        System.out.println(answer);
    }

    private static void find(int n, int x, int y) {

        int zeroCount = 0;
        for (int i = x; i < n + x; i++) {
            for (int j = y; j < n + y; j++) {
                if(data[i][j] == 0){
                    zeroCount++;
                }
            }
        }


        // 종료 조건 - 영역이 0 또는 1만으로 이루어져있다면, 종료
        if(zeroCount == n*n || zeroCount == 0){
            answer.append(zeroCount == 0 ? "1" : "0");
            return;
        }

        int half = n / 2;
        answer.append("(");
        find(half, x, y);
        find(half, x, y + half);
        find(half, x + half, y);
        find(half, x + half, y + half);
        answer.append(")");
    }
}
