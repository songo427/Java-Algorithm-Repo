package baekjoon.silver.exam2512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 2512. 예산
 * 이다은
 */
public class Solution2512D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> require = new PriorityQueue<Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            require.add(Integer.parseInt(st.nextToken()));
        }
        int budget = Integer.parseInt(br.readLine());
        int answer = budget/N;

        while (!require.isEmpty() && require.peek() <= answer) {
            while (!require.isEmpty() && require.peek() <= answer) {
                if (require.size() == 1) {
                    answer = require.poll();
                } else {
                    budget -= require.poll();
                }
            }
            if (!require.isEmpty()) {
                answer = budget/require.size();
            }
        }

        System.out.println(answer);
    }
}
