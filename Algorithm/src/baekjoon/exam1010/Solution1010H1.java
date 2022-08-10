package baekjoon.exam1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1010. 다리 놓기
 * 송현주
 */
public class Solution1010H1 {
    static int R, N;
    static int[] numbers;
    static int totalCnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            String line = br.readLine();
            StringTokenizer tokenizer = new StringTokenizer(line);

            R = Integer.parseInt(tokenizer.nextToken());
            N = Integer.parseInt(tokenizer.nextToken());
            totalCnt = 0;
            numbers = new int[N];

            comb(0, 0);
            System.out.println(totalCnt);
        }
    }

    // 조합
    private static void comb(int cnt, int start) {

        if (cnt == R) {
            totalCnt++;
            return;
        }

        for (int i = start; i < N; i++) {
            numbers[cnt] = i;
            comb(cnt + 1, i + 1);
        }
    }
}
