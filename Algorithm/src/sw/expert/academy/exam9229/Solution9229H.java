package sw.expert.academy.exam9229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 9229. 한빈이와 Spot Mart
 * 송현주
 * */
public class Solution9229H {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            String input = br.readLine();
            StringTokenizer tokenizer = new StringTokenizer(input);
            int N = Integer.parseInt(tokenizer.nextToken());
            int M = Integer.parseInt(tokenizer.nextToken());

            input = br.readLine();
            tokenizer = new StringTokenizer(input);
            int[] weights = new int[N];
            for (int i = 0; i < N; i++) {
                weights[i] = Integer.parseInt(tokenizer.nextToken());
            }
            int sum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i+1; j < N; j++) {
                    int tmp = weights[i] + weights[j];
                    if (tmp <= M && sum < tmp) {
                        sum = tmp;
                    }
                }
            }
            if(sum == 0) sum = -1;
            System.out.println("#" + testCase + " " + sum);
        }
    }
}
