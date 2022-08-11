package sw.expert.academy.d2.exam1926;

import java.util.Scanner;

/**
 * 1926. 간단한 369게임 D2
 * 송현주
 */
public class Solution1926H {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String answer = "";
        for (int i = 1; i <= n; i++) {
            answer += i + " ";
        }
        answer = answer.replaceAll("[369]", "-");
        answer = answer.replaceAll("[0124578]+-|-[0124578]+", "-");

        System.out.println(answer);
    }
}