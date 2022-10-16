package baekjoon.bronze.exam24416;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 24416. 알고리즘 수업 - 피보나치 수 1
 * 송현주
 */
public class Solution24416 {

    static int[] nums;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        nums = new int[41];

        fib(N);
        answer.append(cnt).append(" ");

        // 초기화
        cnt = 0;

        fibonacci(N);
        answer.append(cnt);
        System.out.println(answer);

    }

    // dp
    private static int fibonacci(int num) {

        // 1, 2 저장
        nums[1] = 1;
        nums[2] = 1;

        for (int i = 3; i <= num; i++) {
            cnt++;
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[num];
    }

    // 재귀
    private static int fib(int num) {

        // 1 또는 2가 될 때까지
        if (num == 1 || num == 2) {
            cnt++;
            return 1;
        }
        return fib(num - 1) + fib(num - 2);
    }
}
