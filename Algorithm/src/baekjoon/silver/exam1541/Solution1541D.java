package baekjoon.silver.exam1541;

import java.io.*;
import java.util.*;

/**
 * 1541. 잃어버린 괄호
 * 이다은
 *
 * INPUT: 3+3-3-3+3+3-4
 * OUTPUT: -10
 */
public class Solution1541D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();

        List<Integer> numbers = new ArrayList<>();
        for (String expr : expression.split("-")) {
            String[] nums = expr.split("\\+");
            int number = 0;
            for (String num : nums) {
                number += Integer.parseInt(num);
            }
            numbers.add(number);
        }

        int answer = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            answer -= numbers.get(i);
        }

        System.out.println(answer);
    }
}
