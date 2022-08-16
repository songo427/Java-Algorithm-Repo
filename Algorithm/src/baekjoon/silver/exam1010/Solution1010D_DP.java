package baekjoon.silver.exam1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1010. 다리 놓기 - 조합론과 DP로 풀어보기
 * 이다은
 */
public class Solution1010D_DP {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            dp = new int[30][30];

            int answer = comb(M, N);

            System.out.println(answer);
        }
    }

    private static int comb(int n, int r) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        }

        if (n == r || r == 0) {
            dp[n][r] = 1;
            return 1;
        }

        return dp[n][r] = comb(n-1, r-1) + comb(n-1, r);
    }
}
