package baekjoon.exam2442;

import java.util.Scanner;

/**
 * 2440. 별찍기 5
 * 송현주
 **/

public class SolutionH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder answer = new StringBuilder();
        int num = sc.nextInt();

        for (int line = 1; line <= num; line++) {
            for (int i = 0; i < num - line; i++) {
                answer.append(" ");
            }

            for (int j = 0; j < line * 2 - 1; j++) {
                answer.append("*");
            }
            answer.append("\n");
        }
        System.out.print(answer);
    }
}
