package baekjoon.silver.exam2075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 2075. N번째 큰 수
 * 송현주
 */
public class Solution2075H {
    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // N*N개의 수를 저장할 자료구조
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                queue.offer(Integer.parseInt(st.nextToken()));
            }
        }

        // 출력
        for (int i = 0; i < N - 1; i++) queue.poll();
        System.out.println(queue.peek());
    }
}
