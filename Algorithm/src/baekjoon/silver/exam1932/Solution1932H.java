package baekjoon.silver.exam1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1932. 정수 삼각형
 * 송현주
 */

public class Solution1932H {

    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 값을 저장할 공간
        int[][] dp = new int[N][];

        // 첫번쨰 라인 처리
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp[0] = new int[1];
        dp[0][0] = Integer.parseInt(st.nextToken());

        // 두번쨰 라인부터 처리
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dp[i] = new int[i + 1];

            for (int j = 0; j <= i; j++) {
                // 입력 값 저장
                dp[i][j] = Integer.parseInt(st.nextToken());

                // 라인의 0번째라면 이전 라인의 0번째 값을 저장
                if (j == 0) {
                    dp[i][j] += dp[i - 1][j];
                } else if (j == i) {
                    // 라인의 마지막 번호라면 이전 라인의 마지막 값을 저장
                    dp[i][j] += dp[i - 1][j - 1];
                } else {
                    // 중간에 위치한 값이라면 더 큰 값을 찾아서 저장
                    dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                }
            }
        }
        // 최대값 찾기
        int maxValue = 0;
        for (int n = 0; n < N; n++) maxValue = Math.max(maxValue, dp[N - 1][n]);
        System.out.println(maxValue);
    }
}
