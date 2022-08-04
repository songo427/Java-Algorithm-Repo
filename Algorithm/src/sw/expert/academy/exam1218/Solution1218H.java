package sw.expert.academy.exam1218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 1218. [S/W 문제해결 기본] 4일차 - 괄호 짝짓기
 * 송현주
 */
public class Solution1218H {

    public static Stack stack;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int testCase = 1; testCase <= 10; testCase++) {

            // 케이스 길이
            int N = Integer.parseInt(br.readLine());
            stack = new Stack<>();

            String line = br.readLine();
            char[] brackets = line.toCharArray();
            for (int i = 0; i < N; i++) {
                char cur = brackets[i];

                if (!stack.isEmpty() && isMatched(cur)) stack.pop();
                else stack.push(cur);

            }
            int answer = stack.isEmpty() ? 1 : 0;
            System.out.printf("#%d %d %n", testCase, answer);
        }
    }

    // 괄호 확인
    public static boolean isMatched(char cur) {
        char top = stack.peek().toString().charAt(0);

        if (cur == ')' && top == '(') {
            return true;
        } else if (cur == ']' && top == '[') {
            return true;
        } else if (cur == '}' && top == '{') {
            return true;
        } else if (cur == '>' && top == '<') {
            return true;
        }
        return false;
    }
}
