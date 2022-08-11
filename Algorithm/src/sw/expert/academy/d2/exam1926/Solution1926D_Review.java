package sw.expert.academy.d2.exam1926;

import java.util.Scanner;

public class Solution1926D_Review {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        String answer = "";
        for (int i = 1; i <= n; i++) {
            answer += i + " ";
        }

        answer = answer.replaceAll("[0124578]*[369][0124578]*", "-");
        System.out.println(answer);
    }
}
