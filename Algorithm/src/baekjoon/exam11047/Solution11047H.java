package baekjoon.exam11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 11047. 동전 0
 * 송현주
 */

public class Solution11047H {

    static int[] moneyList;
    static boolean[] isSelected;
    static int N, money;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringTokenizer tokenizer = new StringTokenizer(input);

        N = Integer.parseInt(tokenizer.nextToken());
        money = Integer.parseInt(tokenizer.nextToken());
        moneyList = new int[N];
        isSelected = new boolean[N];

        for (int i = 0; i < N; i++) {
            moneyList[i] = Integer.parseInt(br.readLine().trim());
        }

        Arrays.sort(moneyList);

        int tmp = money;
        int count = 0;
        for (int i = N - 1; i >= 0; ) {
            if (tmp >= moneyList[i]) {
                tmp -= moneyList[i];
                count++;
            } else {
                i--;
            }
        }
        System.out.print(count);
    }
}
