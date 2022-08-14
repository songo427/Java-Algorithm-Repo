package baekjoon.silver.exam9342;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 9342. 염색체
 * 송현주
 * */
public class Solution9342H {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder answer = new StringBuilder();
        String patterns = "^[ABCDEF]?A+F+C+[ABCDEF]?$";
        for (int testCase = 1; testCase <= T; testCase++) {
            String input = br.readLine();
            answer.append(input.matches(patterns) ? "Infected!" : "Good").append("\n");
        }

        System.out.print(answer.toString().trim());
    }
}
