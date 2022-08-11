package sw.expert.academy.d2.exam2007;

import java.util.Scanner;

/**
 * 1954. 패턴 마디의 길이 D2
 * 이다은
 **/
public class Solution2007D {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();

        for (int i = 0; i < T; i++) {
            String str = scn.next();

            int idx = 1;
            int answer = 0;
            String pattern;
            while (idx < str.length()) {
                if (str.charAt(idx) == str.charAt(0)) {
                    answer = idx;
                    pattern = str.substring(0, idx);
                    while (true) {
                        if (str.length() - idx < answer) {
                            idx = str.length();
                            break;
                        }
                        if (str.substring(idx, idx+answer).equals(pattern)){
                            idx = idx + answer;
                        } else {
                            idx++;
                            break;
                        }
                    }
                } else {
                    idx++;
                }
            }

            System.out.println("#" + (i+1) + " " + answer);

        }

    }
}
