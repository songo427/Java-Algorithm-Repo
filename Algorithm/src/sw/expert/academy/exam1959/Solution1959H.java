package sw.expert.academy.exam1959;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1959. 두 개의 숫자열
 * 송현주
 */
public class Solution1959H {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer;
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            answer = new StringBuilder("#" + testCase + " ");
            String nums = br.readLine();
            StringTokenizer tokenizer = new StringTokenizer(nums);
            int N = Integer.parseInt(tokenizer.nextToken());
            int M = Integer.parseInt(tokenizer.nextToken());

            int[] nNums = new int[N];
            int[] mNums = new int[M];

            tokenizer = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                nNums[i] = Integer.parseInt(tokenizer.nextToken());
            }
            tokenizer = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                mNums[i] = Integer.parseInt(tokenizer.nextToken());
            }

            if (N <= M) {
                answer.append(calcMaxSum(M - N + 1, nNums, mNums));
            } else {
                answer.append(calcMaxSum(N - M + 1, mNums, nNums));
            }
            System.out.println(answer);
        }
    }

    public static int calcMaxSum(int loop, int[] a, int[] b) {
        int maxSum = 0;
        int tmp = 0;

        for (int i = 0; i < loop; i++) {
            for (int j = i; j < a.length + i; j++) {
                tmp += a[j - i] * b[j];
            }
            if (maxSum < tmp) {
                maxSum = tmp;
            }
            tmp = 0;
        }
        return maxSum;
    }
}
