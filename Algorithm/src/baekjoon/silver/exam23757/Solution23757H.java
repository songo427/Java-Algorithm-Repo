package baekjoon.silver.exam23757;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 23757. 아이들과 선물 상자
 * 송현주
 */

public class Solution23757H {
    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 초기화
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 선물의 개수를 저정할 자료구조
        PriorityQueue<Integer> presents = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) presents.offer(Integer.parseInt(st.nextToken()));

        // 아이가 원하는 선물의 개수를 저장할 자료구조
        int[] children = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) children[i] = (Integer.parseInt(st.nextToken()));

        // 선물 나누어주기 시작
        int idx = 0; // 학생 순서
        boolean isSuccess = true;
        while (idx < M) {

            // 더 이상 나누어줄 선물이 없다면 종료
            if(presents.isEmpty()) break;

            // 만족할 수 있는 선물이라면
            // 앞서 누군가 선물을 가져갔던 선물 상자에서 또다시 가져가도 상관없음으로 남은 선물 저장
            if (children[idx] <= presents.peek()) {
                presents.offer(presents.peek() - children[idx]);
                presents.poll();
                idx++;
            } else {
                isSuccess = false;
                break;
            }
        }

        // 출력
        System.out.println(isSuccess ? "1" : "0");
    }
}
