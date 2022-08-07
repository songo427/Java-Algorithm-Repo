package sw.expert.academy.exam1970;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1970. 쉬운 거스름돈
 * 송현주
 */

public class Solution1970H {
    public static int[] moneyList = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
    public static int[] changes;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer;
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            changes = new int[8];
            answer = new StringBuilder("#" + testCase + "\n");

            int curMoney = Integer.parseInt(br.readLine());
            calcChanges(curMoney);

            for (int change : changes) {
                answer.append(change + " ");
            }
            System.out.println(answer);
        }
    }

    public static void calcChanges(int curMoney) {
        for (int i = 0; i < 8; ) {
            if (curMoney >= moneyList[i]) {
                curMoney -= moneyList[i];
                changes[i] += 1;
            } else {
                i++;
            }
            if (curMoney == 0) {
                break;
            }
        }
    }
}