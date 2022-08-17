package baekjoon.silver.exam11729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 11729. 하노이 탑 이동 순서
 * 송현주
 */
public class Solution11729H {
    static StringBuilder answer;
    static int count;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        count = 0;
        hanoi(N, 1, 2, 3);
        System.out.println(count);
        System.out.print(answer);
    }

    private static void hanoi(int n, int start, int tmp, int end) {

        // 마지막 하나는 최종 기둥으로 옮긴다.
        if (n == 1) {
            answer.append(start + " " + end + "\n");
            count ++;
            return;
        }

        // n-1개의 원반을 시작에서 -> 보조 기둥으로 옮긴다.
        hanoi(n - 1, start, end, tmp);
        answer.append(start + " " + end + "\n");
        count ++;

        // 보조 기둥에 있는 원반을 최종 목적지로 옮긴다.
        hanoi(n - 1, tmp, start, end);
    }
}
