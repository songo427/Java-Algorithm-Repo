package baekjoon.silver.exam1049;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1049. 기타줄
 * 송현주
 */
public class Solution1049H {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        int N = Integer.parseInt(st.nextToken()); // 적어도 N개를 사는 것이 목표
        int M = Integer.parseInt(st.nextToken());

        int[] packages = new int[M];
        int[] units = new int[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            packages[i] = Integer.parseInt(st.nextToken()); // 브랜드 패키지 가격
            units[i] = Integer.parseInt(st.nextToken()); // 낱개 가격
        }

        // 정렬
        Arrays.sort(packages);
        Arrays.sort(units);

        // 1) 패키지로 구매하는 경우 vs 낱개로 구매하는 경우
        answer = Math.min(((N / 6) + 1) * packages[0], N * units[0]);

        // 2) 패키지와 낱개 조합으로 구매하는 경우
        answer = Math.min(answer, N / 6 * packages[0] + N % 6 * units[0]);
        System.out.println(answer);
    }
}


