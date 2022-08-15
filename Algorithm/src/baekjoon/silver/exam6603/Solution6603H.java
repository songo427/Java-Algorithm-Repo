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
    static boolean[] isSelected;
    static StringBuilder answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            answer = new StringBuilder();
            String input = br.readLine();
            if (input.equals("0")) return;
            StringTokenizer tokenizer = new StringTokenizer(input, " ");

            K = Integer.parseInt(tokenizer.nextToken());
            inputNums = new int[K];
            lottoNums = new int[6];
            isSelected = new boolean[50];
            for (int i = 0; i < K; i++) {
                inputNums[i] = Integer.parseInt(tokenizer.nextToken());
            }
            comb(0, 0);
            answer.append("\n");
            System.out.print(answer);
        }

    }

    private static void comb(int start, int cnt) {
        if (cnt == 6) {
            printLottoNums();
            return;
        }

        for (int i = start; i < K; i++) {
            isSelected[i] = true;
            lottoNums[cnt] = inputNums[i];
            comb(i + 1, cnt + 1);
            isSelected[i] = false;
        }
    }

    private static void printLottoNums() {
        for (int num : lottoNums) {
            answer.append(num + " ");
        }
        answer.append("\n");
    }
}
