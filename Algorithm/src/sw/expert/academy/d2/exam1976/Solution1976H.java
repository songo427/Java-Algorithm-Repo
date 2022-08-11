package sw.expert.academy.d2.exam1976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1976. 시각 덧셈 D2
 * 송현주
 */
public class Solution1976H {
    static int hour;
    static int minute;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());

        for (int testCase = 1; testCase <= T; testCase++) {
            hour = 0;
            minute = 0;

            String input = br.readLine();
            StringTokenizer tokenizer = new StringTokenizer(input, " ");
            hour += Integer.parseInt(tokenizer.nextToken());
            minute += Integer.parseInt(tokenizer.nextToken());
            hour += Integer.parseInt(tokenizer.nextToken());
            minute += Integer.parseInt(tokenizer.nextToken());
            checkHourAndMinute();
            System.out.println("#" + testCase + " " + hour + " " + minute);
        }
    }

    private static void checkHourAndMinute() {
        if (minute >= 60) {
            minute -= 60;
            hour += 1;
        }

        if (hour >= 13) {
            hour -= 12;
        }
    }

}
