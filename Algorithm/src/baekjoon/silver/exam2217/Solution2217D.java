package baekjoon.silver.exam2217;

import java.io.*;
import java.util.Arrays;

public class Solution2217D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] rope = new int[N];
        for (int i = 0; i < N; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(rope);
        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, rope[i]*(N-i));
        }

        System.out.println(answer);
    }
}
