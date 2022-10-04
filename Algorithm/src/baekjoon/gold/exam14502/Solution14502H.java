package baekjoon.gold.exam14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 14502. 연구소
 * 송현주
 */

public class Solution14502H {

    // 클래스 생성
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, maxCount;
    static int[][] map;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상 - 하 - 좌 - 우


    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 맵 생성
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 벽을 세운다.
        addWalls(0);

        // 출력
        System.out.println(maxCount);

    }

    private static void addWalls(int cnt) {

        // 총 세개의 벽을 세운다.
        if (cnt == 3) {
            search();
            return;
        }

        // 벽이 세개가 될 때까지 반복한다.
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (map[x][y] != 0) continue;
                map[x][y] = 1;
                addWalls(cnt + 1);
                map[x][y] = 0;
            }
        }
    }

    // 맵 복사
    private static int[][] copyMap() {
        int[][] copy = new int[N][M];
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                copy[x][y] = map[x][y];
            }
        }
        return copy;
    }

    // 바이러스 위치를 기준으로 bfs탐색 진행한다.
    private static void search() {

        int[][] nMap = copyMap();

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {

                // 현재 위치가 바이러스가 아니라면 탐색 x
                if (nMap[x][y] != 2) continue;
                bfs(new Point(x, y), nMap);
            }
        }

        findSafeArea(nMap);
    }

    // 바이러스 방향대로 bfs탐색을 진행한다.
    private static void bfs(Point point, int[][] nMap) {

        Queue<Point> queue = new ArrayDeque<>();
        queue.add(point);

        while (!queue.isEmpty()) {

            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dirs[i][0];
                int ny = current.y + dirs[i][1];

                if(!isIn(nx, ny) || nMap[nx][ny] != 0) continue;

                nMap[nx][ny] = 2;
                queue.add(new Point(nx, ny));
            }
        }
    }

    // 안전영역을 찾아 수를 센다.
    private static void findSafeArea(int[][] nMap) {

        int count = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (nMap[x][y] == 0) count++;
            }
        }

        // 최대값 갱신
        maxCount = Math.max(maxCount, count);
    }

    // 범위 확인
    private static boolean isIn(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < M;
    }

    // 출력
    private static void print(int[][] arr) {
        for (int[] line : arr) {
            for (int num : line) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
