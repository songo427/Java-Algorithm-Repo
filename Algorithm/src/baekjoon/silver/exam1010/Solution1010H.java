package baekjoon.silver.exam1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1010. 다리 놓기
 * 송현주
 */
public class Solution1010H {
    static int R, N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            String line = br.readLine();
            StringTokenizer tokenizer = new StringTokenizer(line);

            R = Integer.parseInt(tokenizer.nextToken());
            N = Integer.parseInt(tokenizer.nextToken());

            int answer = 1;

            for (int i = 0; i < R; i++) {
                answer *= N - i;
                answer /= i + 1;
            }
            System.out.println(answer);
        }
    }
}
