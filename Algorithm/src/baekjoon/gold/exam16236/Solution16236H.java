package baekjoon.gold.exam16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * 16236. 아기 상어
 * 송현주
 * */
public class Solution16236H {

    static int[][] space;
    static int N;

    static Queue<Fish> queue;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        space = new int[N][N];

        int x = 0;
        int y = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                space[i][j] = Integer.parseInt(tokenizer.nextToken());
                if (space[i][j] == 9) {
                    x = i;
                    y = j;
                }
            }
        }
        findFish(2, x, y);
        System.out.println(Arrays.deepToString(space));
    }

    private static boolean isIn(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < N;
    }

    private static void findFish(int current, int x, int y) {

        List<Fish> targets = new ArrayList<>();

        while (true){

            // 작은 물고기 있는지 찾기 - 있다면, 리스트에 담기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(space[i][j] != 0 && current > space[i][j]){
                        targets.add(new Fish(i, j, space[i][j]));
                    }
                }
            }
            System.out.println("먹을 물고기");
            System.out.println(targets);
            // 작은 물고기가 한 마리라면 해당 물고기 먹기
            if(targets.size() == 1) {
                System.out.println("target: "+targets.get(0));
                targets.clear();
            }

            // 작은 물고기가 여러 마리라면 거리가 가장 가까운 물고기 먹기

            // 거리가 같은 물고기가 많다면, 가장 위에 있는 물고기 먹기

            // 위에 있는 물고기들 거리가 같다면, 왼쪽에 있는 물고기 먹기

            // 더 이상 이동할 수 없다면,
            if(targets.size() == 0){
                return;
            }
        }
    }


    static class Fish {
        int x, y;
        int distance; // 거리 저장해서 얼마나 걸리는지 확인

        public Fish(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "Fish{" +
                    "x=" + x +
                    ", y=" + y +
                    ", distance=" + distance +
                    '}';
        }
    }
}
