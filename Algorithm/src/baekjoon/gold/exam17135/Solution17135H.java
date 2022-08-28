package baekjoon.gold.exam17135;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


/**
 * 17135. 캐슬 디펜스
 * 송현주
 * */
public class Solution17135H {

    static int N, M, D;
    static int[] loc;
    static List<List<Integer>> castle;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringTokenizer tokenizer = new StringTokenizer(input, " ");

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        D = Integer.parseInt(tokenizer.nextToken()); // 1 ~ 10

        loc = new int[3];
        castle = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            input = br.readLine();
            List<Integer> line = new ArrayList<>();
            tokenizer = new StringTokenizer(input, " ");
            for (int j = 0; j < M; j++) {
                line.add(Integer.parseInt(tokenizer.nextToken()));
            }
            castle.add(line);
        }
        System.out.println(castle);

        while (!castle.isEmpty()) {

            // 배치에 현재 배치 상태


            // 거리 탐색


            // 적 이동
            moveEnemy();
        }

        comb(0,0);
    }

    private static void moveEnemy() {
        castle.remove(0);
        System.out.println(castle);
    }

    // 거리 계산
    private static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    // 조합
    private static void comb(int cnt, int start) {
        if (cnt == 3) {
            System.out.println(Arrays.toString(loc));
            return;
        }

        for (int i = start; i < M; i++) {

            loc[cnt] = i;
            comb(cnt + 1, i + 1);
        }
    }

}
