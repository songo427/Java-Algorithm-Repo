package sw.expert.academy.exam1976;

import java.io.*;
import java.util.*;

/**
 * 1976. 시각 덧셈
 * 이다은
 */
public class Solution1976D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            int hour = Integer.parseInt(st.nextToken());
            int minute = Integer.parseInt(st.nextToken());
            hour += Integer.parseInt(st.nextToken());
            minute += Integer.parseInt(st.nextToken());

            if (minute >= 60) {
                minute -= 60;
                hour ++;
            }

            if (hour > 12) {
                hour -= 12;
            }

            System.out.println("#" + i + " " + hour + " " + minute);
        }
    }
}
