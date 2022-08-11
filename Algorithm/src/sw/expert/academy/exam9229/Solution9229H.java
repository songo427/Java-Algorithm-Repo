package sw.expert.academy.exam9229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 9229. 한빈이와 Spot Mart
 * 송현주
 */
public class Solution9229H {
    public static int[] weights;
    public static int[] snackSum;
    public static int maxSum, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            String input = br.readLine();
            StringTokenizer tokenizer = new StringTokenizer(input);
            int N = Integer.parseInt(tokenizer.nextToken());
            M = Integer.parseInt(tokenizer.nextToken());

            input = br.readLine();
            tokenizer = new StringTokenizer(input);
            weights = new int[N];
            for (int i = 0; i < N; i++) {
                weights[i] = Integer.parseInt(tokenizer.nextToken());
            }

            snackSum = new int[2];
            maxSum = 0;
            combination(0, 0);
            System.out.println("#" + testCase + " " + maxSum);
        }
    }

    // 조합 사용하기
    public static void combination(int cnt, int start) {
        if (cnt == 2) {
            int sum = snackSum[0] + snackSum[1];
            if (sum <= M && maxSum < sum) {
                maxSum = sum;
            }
            return;
        }

        for (int i = start; i < weights.length; i++) {
            snackSum[cnt] = weights[i];
            combination(cnt + 1, i + 1);
        }

    }
}
