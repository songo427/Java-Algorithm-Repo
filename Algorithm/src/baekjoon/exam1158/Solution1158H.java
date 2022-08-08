package baekjoon.exam1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1158H {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringTokenizer tokenizer = new StringTokenizer(input, " ");
        StringBuilder answer = new StringBuilder("<");
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());

        Queue<Integer> people = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            people.add(i);
        }

        int idx = 0;
        while (!people.isEmpty()) {
            int cur = people.poll();
            if (idx != K - 1) {
                people.add(cur);
                idx++;
            }else {
                answer.append(cur+", ");
                idx = 0;
            }
        }
        answer = answer.replace(answer.length()-2,answer.length(),"");
        answer.append(">");
        System.out.println(answer);
    }
}
