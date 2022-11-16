package baekjoon.gold.exam10942;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 10942. 팰린드롬?
 * 이다은
 */
public class Solution10942D {
    static int[][] dp;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        num = new int[N];
        dp = new int[N+1][N+1];
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(dp[i], -1);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            dp[i+1][i+1] = 1;
            if (i > 0 && num[i-1] == num[i]) {
                dp[i][i+1] = 1;
            } else {
                dp[i][i+1] = 0;
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(isPalindrome(start, end)).append("\n");
        }

        System.out.println(sb);
    }

    static int isPalindrome(int start, int end) {
        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        if (isPalindrome(start+1, end-1) == 1) {
            if (num[start-1] == num[end-1]) {
                dp[start][end] = 1;
            } else {
                dp[start][end] = 0;
            }
        } else {
            dp[start][end] = 0;
        }

        return dp[start][end];
    }
}

/*
7
1 2 1 1 2 2 3
4
1 3
2 5
3 3
5 7

=> 1 1 1 0
 */