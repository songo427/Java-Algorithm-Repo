package baekjoon.silver.exam15903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 15903. 카드 합체 놀이
 * 송현주
 * */

public class Solution15903H {
    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 초기화
        long answer = 0; // 최종 결과를 저장할 변수
        long N = Integer.parseInt(st.nextToken()); // 카드의 수
        long M = Integer.parseInt(st.nextToken()); // 카드 합체 횟수

        // 카드를 저장할 자료구조
        PriorityQueue<Long> queue = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            queue.add(Long.parseLong(st.nextToken()));
        }

        // 카드 합체 횟수 만큼 반복
        while(M -- > 0 && !queue.isEmpty()) {
            long sum = 0;
            for(int i=0; i<2; i++) sum += queue.poll();
            for(int i=0; i<2; i++) queue.add(sum);
        }

        // 합 계산
        for(int i=0; i<N; i++) answer += queue.poll();
        System.out.println(answer);
    }
}
