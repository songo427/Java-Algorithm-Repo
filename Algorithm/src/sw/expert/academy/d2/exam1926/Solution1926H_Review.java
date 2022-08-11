package sw.expert.academy.d2.exam1926;

import java.util.Scanner;

public class Solution1926H_Review {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String answer = "";
        for (int i = 1; i <= n; i++) {
            answer += i + " ";
        }

        answer = answer.replaceAll("[0124578]*[369][0124578]*", "-");
        System.out.println(answer);

    }
}
