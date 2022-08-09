package sw.expert.academy.exam1948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1948. 날짜 계산기
 * 송현주
 */
public class Solution1948H {
    public static void main(String[] args) throws IOException {

        int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());


        for (int testCase = 1; testCase <= T; testCase++) {
            int[][] start = new int[1][2];
            int[][] end = new int[1][2];
            String input = br.readLine();
            StringTokenizer tokenizer = new StringTokenizer(input, " ");

            start[0][0] = Integer.parseInt(tokenizer.nextToken());
            start[0][1] = Integer.parseInt(tokenizer.nextToken());

            end[0][0] = Integer.parseInt(tokenizer.nextToken());
            end[0][1] = month[end[0][0] - 1] - Integer.parseInt(tokenizer.nextToken());

            int totalDate = 0;
            for (int i = start[0][0]; i <= end[0][0]; i++) {
                totalDate += month[i - 1];
            }

            totalDate = totalDate - start[0][1] - end[0][1] + 1;
            System.out.println("#" + testCase + " " + totalDate);
        }
    }
}
