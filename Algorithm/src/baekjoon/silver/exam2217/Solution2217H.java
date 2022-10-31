package baekjoon.silver.exam2217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 * 2217. 로프
 * 송현주
 */

public class Solution2217H {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 입력 저장
        Integer[] items = new Integer[N];
        for (int i = 0; i < N; i++) {
            items[i] = Integer.parseInt(br.readLine());
        }

        // 정렬 - 내림차순
        Arrays.sort(items, Collections.reverseOrder());
        System.out.println(Arrays.toString(items));


        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, items[i - 1] * i);
        }
        System.out.println(answer);
    }
}
