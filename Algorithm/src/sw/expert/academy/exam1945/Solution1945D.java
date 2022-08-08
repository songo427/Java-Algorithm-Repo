package sw.expert.academy.exam1945;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1945. 간단한 소인수분해
 * 이다은
 */
public class Solution1945D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= T; i++) {
            int num = Integer.parseInt(reader.readLine());

            int[] divider = {2, 3, 5, 7, 11};
            int[] answer = new int[5];
            for (int j = 0; j < divider.length; j++) {
                while (num % divider[j] == 0) {
                    answer[j]++;
                    num /= divider[j];
                }
            }

            System.out.print("#" + i + " ");
            for (int ans : answer) {
                System.out.print(ans + " ");
            }
            System.out.println();
        }
    }
}
