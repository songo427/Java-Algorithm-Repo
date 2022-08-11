package sw.expert.academy.d2.exam1926;

import java.util.Scanner;

/**
 * 1926. 간단한 369게임 D2
 * 이다은
 **/
public class Solution1926D {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        String answer = "";
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (char c : (i + "").toCharArray()) {
                if (c == '3' || c == '6' || c == '9') {
                    count++;
                }
            }

            if (count > 0) {
                for (int j = 0; j < count; j++) {
                    answer += "-";
                }
                answer += " ";
            } else {
                answer += i +" ";
            }
        }

        System.out.println(answer);
    }
}
