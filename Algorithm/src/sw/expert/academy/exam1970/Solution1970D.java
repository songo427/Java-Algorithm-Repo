package sw.expert.academy.exam1970;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1970D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] monetaryUnit = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

        for (int i = 1; i <= T; i++) {
            int money = Integer.parseInt(br.readLine());
            int[] answer = new int[8];
            for (int j = 0; j < 8; j++) {
                answer[j] = money / monetaryUnit[j];
                money %= monetaryUnit[j];
            }

            System.out.println("#" + i);
            for (int ans : answer) {
                System.out.print(ans + " ");
            }
            System.out.println();
        }
    }
}
