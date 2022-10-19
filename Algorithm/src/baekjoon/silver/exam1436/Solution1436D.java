package baekjoon.silver.exam1436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1436. 영화감독 숌
 * 이다은
 */
public class Solution1436D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        int cnt = 0;
        while (cnt < N) {
            answer++;
            if ((answer + "").contains("666")) {
                cnt++;
            }
        }

        System.out.println(answer);
    }
}
