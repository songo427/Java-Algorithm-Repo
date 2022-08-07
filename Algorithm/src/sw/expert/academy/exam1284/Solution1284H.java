package sw.expert.academy.exam1284;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1284. 수도 요금 경쟁
 * 송현주
 */

public class Solution1284H {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer;
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            answer = new StringBuilder("#" + testCase + " ");
            String input = br.readLine();
            StringTokenizer tokenizer = new StringTokenizer(input);

            int P = Integer.parseInt(tokenizer.nextToken()); // P(A사-1L당 금액)
            int Q = Integer.parseInt(tokenizer.nextToken()); // Q(B사-기본요금)
            int R = Integer.parseInt(tokenizer.nextToken()); // R(B사-월간 사용량)
            int S = Integer.parseInt(tokenizer.nextToken()); // S(B사-추가요금)
            int W = Integer.parseInt(tokenizer.nextToken()); // W(한달간 수도 사용량)

            int aAmount = P * W;
            int bAmount = W <= R ? Q : Q + (S * (W - R));

            answer.append(Math.min(aAmount, bAmount));
            System.out.println(answer);
        }
    }
}
