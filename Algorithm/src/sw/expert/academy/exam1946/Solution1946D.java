package sw.expert.academy.exam1946;

import java.util.Scanner;

/**
 * 1946. 간단한 압축 풀기 D2
 * 이다은
 **/
public class Solution1946D {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        for (int i = 1; i <= t; i++) {
            int num = scn.nextInt();
            StringBuilder doc = new StringBuilder();
            for (int j = 0; j < num; j++) {
                String alpha = scn.next();
                int cnt = scn.nextInt();

                // doc.append(alpha.repeat(cnt)); -> Java11부터는 이렇게 할 수 있음
                for (int k = 0; k < cnt; k++) {
                    doc.append(alpha);
                }
            }

            System.out.println("#" + i);
            int idx = 0;
            while (idx < doc.length()) {
                if (doc.length() - idx < 10) {
                    System.out.println(doc.substring(idx));
                    idx = doc.length();
                } else {
                    System.out.println(doc.substring(idx, idx + 10));
                    idx += 10;
                }
            }
        }
    }
}
