package baekjoon.gold.exam9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution9935H {

    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        char[] input = br.readLine().toCharArray();
        String target = br.readLine();

        // 문자열 길이만큼 반복
        for (int i = 0; i < input.length; i++) {

            // 문자열 추가
            answer.append(input[i]);

            // 폭발 문자열보다 스택에 추가된 문자열이 더 긴 경우
            // 폭발 문자열이 포함될 수 있음
            if (target.length() <= answer.length()) {

                // 폭발 문자열 포함 여부
                boolean isContain = true;

                // 폭발 문자열 길이만큼 반복
                for (int j = 0; j < target.length(); j++) {
                    if (answer.charAt(answer.length() - target.length() + j) != target.charAt(j)) {
                        isContain = false;
                        break;
                    }
                }

                // 폭발 문자열이 포함되어 있다면 제거
                if (isContain) {
                   answer.delete(answer.length() - target.length(), answer.length());
                }
            }

        }

        // 출력
        if(answer.length() == 0) answer.append("FRULA");
        System.out.println(answer);
    }
}

