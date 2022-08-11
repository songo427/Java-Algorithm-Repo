package baekjoon.bronze.exam2439;

import java.util.Scanner;

/**
 * 2439. 별찍기 1
 * 송현주
 **/

public class SolutionH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        // for
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < num - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // java 11 - use repeat()
        // for (int i = 1; i <= num; i++) {
        //     System.out.println(" ".repeat(num - i) + "*".repeat(i));
        // }
    }
}
