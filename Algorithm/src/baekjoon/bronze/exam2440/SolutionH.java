package baekjoon.bronze.exam2440;

import java.util.Scanner;

/**
 * 2440. 별찍기 2
 * 송현주
 **/

public class SolutionH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < num; i++) {

            for (int j = num - i; j > 0; j--) {
                answer.append("*");
            }
            answer.append("\n");
        }
        System.out.print(answer.toString().trim());
    }
}
