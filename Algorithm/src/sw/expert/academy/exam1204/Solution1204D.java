package sw.expert.academy.exam1204;

import java.util.*;

/**
 * 1204. [S/W 문제해결 기본] 1일차 - 최빈수 구하기
 * 이다은
 **/

public class Solution1204D {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();

        for (int i = 0; i < T; i++) {
            int n = scn.nextInt();

            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

            for (int j = 0; j < 1000; j++) {
                int score = scn.nextInt();
                map.put(score, map.getOrDefault(score, 0) + 1);
            }

            int answer = 0;
            int max_cnt = 0;
            for (int k : map.keySet()) {
                if (max_cnt < map.get(k)) {
                    max_cnt = map.get(k);
                    answer = k;
                } else if (max_cnt == map.get(k)) {
                    if (k > answer) {
                        answer = k;
                    }
                }
            }

            System.out.println("#" + n + " " + answer);
        }

    }
}
