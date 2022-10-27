package baekjoon.silver.exam14235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 14235. 크리스마스 선물
 * 송현주
 */

public class Solution14235H {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 총 방문 횟수
        StringBuilder answer = new StringBuilder();

        // 산타가 가지고 있는 선물 저장
        PriorityQueue<Integer> presents = new PriorityQueue<>(Collections.reverseOrder());

        // 산태 배송 시작
        for (int i = 0; i < N; i++) {

            // 입력
            String cur = br.readLine();

            // 0 : 착한 아이를 만남 - 선물 제공
            if(cur.equals("0")) {
                // 가지고 있는 선물이 없다면 -1, 있다면 가장 큰 선물 제공
                answer.append(presents.isEmpty() ? "-1" : presents.poll()).append("\n");
            }
            // 그 외의 수라면 선물 충천
            else {
                StringTokenizer st = new StringTokenizer(cur, " ");
                int loop = Integer.parseInt(st.nextToken());
                for(int k = 0; k < loop; k++) {
                    presents.offer(Integer.parseInt(st.nextToken()));
                }
            }
        }
        System.out.println(answer);
    }
}
