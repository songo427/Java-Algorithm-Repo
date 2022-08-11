package baekjoon.silver.exam1010;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 1010. 다리 놓기
 * 이다은
 */
public class Solution1010D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int answer = 1;
            for (int j = 0; j < N; j++) {
                answer *= M-j;
                answer /= j+1;
            }

            System.out.println(answer);
        }
    }
}
