package baekjoon.silver.exam14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 14501. 퇴사
 * 송현주
 */

public class Solution14501H {

    static int[][] plan;
    static int N, answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        plan = new int[N + 1][2];

        // 입력
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            plan[i][0] = Integer.parseInt(st.nextToken());
            plan[i][1] = Integer.parseInt(st.nextToken());
        }

        consult(1, 0);
        System.out.println(answer);
    }

    // 탐색
    private static void consult(int start, int sum) {

        // 근무 기간을 만료했다면 종료
        if (start >= N + 1) {
            if (start == N + 1) {
                answer = Math.max(answer, sum);
            }
            return;
        }

        // 상담 진행 ok
        consult(start + plan[start][0], sum + plan[start][1]);

        // 상담 진행 x
        consult(start + 1, sum);
    }
}
