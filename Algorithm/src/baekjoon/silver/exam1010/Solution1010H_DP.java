package baekjoon.silver.exam1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1010H_DP {
    static int R, N;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            String line = br.readLine();
            StringTokenizer tokenizer = new StringTokenizer(line);

            R = Integer.parseInt(tokenizer.nextToken());  // N
            N = Integer.parseInt(tokenizer.nextToken());  // M
            dp = new int[N+1][R+1];
            System.out.println(comb(N, R));
        }
    }

    private static int comb(int n, int r) {
        if (r == n || r == 0) {
            return 1;
        }

        if (dp[n][r] != 0) {
            return dp[n][r];
        }

        return dp[n][r] = comb(n - 1, r - 1) + comb(n - 1, r);
    }
}