package sw.expert.academy.exam6808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 6808. 규영이와 인영이의 카드게임
 * 송현주
 */
public class Solution6808H {
    public static int[] kyCards, iyCards, cards; // 사용한 카드 저장 cards
    public static boolean[] isSelected;
    public static int kyWinCount, iyWinCount;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            String input = br.readLine();
            StringTokenizer tokenizer = new StringTokenizer(input, " ");

            kyWinCount = 0;
            iyWinCount = 0;
            boolean[] tmp = new boolean[19];
            isSelected = new boolean[19];
            cards = new int[9];
            kyCards = new int[9];
            iyCards = new int[9];

            for (int i = 0; i < 9; i++) {
                int card = Integer.parseInt(tokenizer.nextToken());
                kyCards[i] = card;
                tmp[card] = true;
            }

            int idx = 0;
            for (int i = 1; i <= 18; i++) {
                if (!tmp[i]) {
                    iyCards[idx] = i;
                    idx++;
                }
            }

            perm(0);
            System.out.println("#" + testCase + " " + kyWinCount + " " + iyWinCount);
        }
    }

    private static void perm(int cnt) {
        if (cnt == 9) {
            int kyScore = 0, iyScore = 0;
            for (int i = 0; i < 9; i++) {
                if (kyCards[i] > cards[i]) {
                    kyScore += kyCards[i] + cards[i];
                } else if (kyCards[i] < cards[i]) {
                    iyScore += kyCards[i] + cards[i];
                }
            }

            if (kyScore > iyScore) kyWinCount++;
            else if (kyScore < iyScore) iyWinCount++;
            return;
        }

        // 9개 숫자를 뽑아서 만든다.
        for (int i = 0; i < 9; i++) {
            if (isSelected[i]) continue;

            // 선택 x 사용
            cards[cnt] = iyCards[i];
            isSelected[i] = true;
            perm(cnt + 1);
            isSelected[i] = false;
        }

    }
}

