package baekjoon.silver.exam6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 6603. 로또
 * 송현주
 */
public class Solution6603H {

    static int K;
    static int[] inputNums, lottoNums;
    static StringBuilder answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            answer = new StringBuilder();
            String input = br.readLine();

            // 입력이 0이면 종료
            if (input.equals("0")) return;

            // 입력
            StringTokenizer tokenizer = new StringTokenizer(input, " ");
            K = Integer.parseInt(tokenizer.nextToken());
            inputNums = new int[K];
            lottoNums = new int[6];
            for (int i = 0; i < K; i++) {
                inputNums[i] = Integer.parseInt(tokenizer.nextToken());
            }

            // 로또 번호 조합
            comb(0, 0);
            answer.append("\n");
            System.out.print(answer);
        }
    }

    // 로또 번호 조합
    private static void comb(int start, int cnt) {
        if (cnt == 6) {
            printLottoNums();
            return;
        }

        for (int i = start; i < K; i++) {
            lottoNums[cnt] = inputNums[i];
            comb(i + 1, cnt + 1);
        }
    }

    // 번호 출력
    private static void printLottoNums() {
        for (int num : lottoNums) {
            answer.append(num + " ");
        }
        answer.append("\n");
    }
}
