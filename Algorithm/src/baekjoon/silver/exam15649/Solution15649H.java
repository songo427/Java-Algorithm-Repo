package baekjoon.silver.exam15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 15649. N과 M (1)
 * 송현주
 */
public class Solution15649H {
    static int N, M;
    static int[] combinedNums;
    static boolean[] isSelected;

    static StringBuilder answer;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = new StringBuilder();
        String input = br.readLine();
        StringTokenizer tokenizer = new StringTokenizer(input, " ");
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken()); // R
        combinedNums = new int[M];
        isSelected = new boolean[N + 1];
        solution(0, 1);
        System.out.print(answer);
    }

    private static void solution(int cnt, int start) {
        if (cnt == M) {
            printNums(combinedNums);
            return;
        }

        for (int i = start; i <= N; i++) {
            if(isSelected[i]) continue;
            combinedNums[cnt] = i;
            isSelected[i] = true;
            solution(cnt + 1, start);
            isSelected[i] = false;
        }
    }

    private static void printNums(int[] nums){
        for(int num : nums){
            answer.append(num + " ");
        }
        answer.append("\n");
    }
}
