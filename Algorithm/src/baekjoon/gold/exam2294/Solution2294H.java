package baekjoon.gold.exam2294;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * 2294. 동전2
 * 송현주
 */

public class Solution2294H {

    static int[] coins;
    static int[] dp;
    static int N, K;

    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 동전 종류
        K = Integer.parseInt(st.nextToken()); // 목표 금액

        // 동전 저장
        coins = new int[K];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        // dp 배열 생성
        dp = new int[K + 1];

        // dp 배열 초기 가치 저장
        Arrays.fill(dp, 10001);

        // 0원은 0개의 동적이 필요함으로 dp[0] = 0;
        dp[0] = 0;

        // 값 갱신
        // 동전 수만큼 반복
        for (int n = 0; n < N; n++) {
            updateDP(n);
        }

        // 출력
        System.out.println(dp[K] == 10001 ? -1 : dp[K]);
    }

    private static void updateDP(int n) {
        for (int money = coins[n]; money <= K; money++) {
            dp[money] = Math.min(dp[money], dp[money - coins[n]] + 1);
        }
    }
}
