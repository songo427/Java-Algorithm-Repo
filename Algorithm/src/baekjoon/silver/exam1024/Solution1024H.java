package baekjoon.silver.exam1024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1024. 수열의 합
 * 송현주
 */

public class Solution1024H {
    static int N, L;
    static int[] result; // 결과 순열 저장
    static StringBuilder answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = new StringBuilder();

        String input = br.readLine();
        StringTokenizer tokenizer = new StringTokenizer(input, " ");
        N = Integer.parseInt(tokenizer.nextToken());
        L = Integer.parseInt(tokenizer.nextToken());

        int initValue = 0;
        for (int i = 0; i < L; i++) {
            initValue += i;
        }

        int length = L;
        while (true) {
            if ((N - initValue) % length == 0) break;
            initValue += length;
            length++;
        }

        // length 크기 만큼 배열 생성
        result = new int[length];

        // 조건에 만족하는 수열을 찾았는지 여부
        boolean isFound = false;

        // length는 100보다 작은 경우만 가능 함
        if (length <= 100) {

            // 0부터 N까지 length개 만큼 탐색
            for (int i = 0; i <= N; i++) {
                int sum = 0;
                for (int j = 0; j < length; j++) {
                    sum += j + i;
                    result[j] = j + i;
                }

                // length개의 수열의 합이 N과 같고, 수열의 개수가 length보다 크거나 같다면,
                if (sum == N && result.length >= length) {
                    printAnswer();
                    isFound = true;
                    break;
                }
            }
        }

        // 끝까지 찾지 못했다면 -1
        if (!isFound) answer.append(-1);

        System.out.println(answer);
    }

    // 출력
    private static void printAnswer() {
        for (int num : result) {
            answer.append(num + " ");
        }
    }
}