package sw.expert.academy.exam4012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 4012. [모의 SW 역량테스트] 요리사
 * 송현주
 * */
public class Solution4012H {
    static int N, minNum;
    static int[][] table;
    static int[] comb;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int testCase = 1; testCase <= T; testCase++) {

            N = Integer.parseInt(br.readLine().trim());
            table = new int[N + 1][N + 1];
            comb = new int[N / 2];
            isSelected = new boolean[N + 1];
            minNum = Integer.MAX_VALUE;
            for (int i = 1; i <= N; i++) {
                String input = br.readLine();
                StringTokenizer tokenizer = new StringTokenizer(input, " ");
                for (int j = 1; j <= N; j++) {
                    table[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }
            cook(0, 1);
            System.out.println("#" + testCase + " " + minNum);
        }
    }

    private static void cook(int cnt, int start) {

        if (cnt == N / 2) {
            int aFood = 0, bFood = 0;
            int[] aTmp = new int[N / 2];
            int[] bTmp = new int[N / 2];
            int aIdx = 0, bIdx = 0;
            for (int i = 1; i <= N; i++) {
                if (!isSelected[i]) {
                    bTmp[bIdx++] = i;
                } else {
                    aTmp[aIdx++] = i;
                }
            }

            for (int i = 0; i < N / 2; i++) {
                for (int j = i; j < N / 2; j++) {
                    aFood += table[aTmp[i]][aTmp[j]] + table[aTmp[j]][aTmp[i]];
                    bFood += table[bTmp[i]][bTmp[j]] + table[bTmp[j]][bTmp[i]];
                }
            }
            if (minNum > Math.abs(aFood - bFood)) {
                minNum = Math.abs(aFood - bFood);
            }
            return;
        }

        for (int i = start; i <= N; i++) {
            comb[cnt] = i;
            isSelected[i] = true;
            cook(cnt + 1, i + 1);
            isSelected[i] = false;
        }
    }
}
