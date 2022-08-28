package baekjoon.gold.exam3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 3055. 탈출
 * 송현주
 */
public class Solution3055H {

    // 상 - 하 - 좌 - 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static char[][] map;
    static List<Point> water, location;
    static Queue<Point> queue;

    static boolean[][] visited;

    static int R, C, minTime, time;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        water = new ArrayList<>();
        location = new ArrayList<>();
        visited = new boolean[R][C];
        queue = new ArrayDeque<>();

        int x = 0;
        int y = 0;

        // 입력
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            map[i] = input.toCharArray();

            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'S') {
                    x = i;
                    y = j;
                }

                if (map[i][j] == '*') {
                    water.add(new Point(i, j));
                }
            }
        }

        // 입력 확인
        System.out.println("map 생성!");
        for (char[] line : map) {
            for (char c : line) {
                System.out.print(c + " ");
            }
            System.out.println();
        }

        minTime = 0;
        time = 0;
        // 탐색 시작
        search(x, y);

        System.out.println("탐색 후!");
        for (char[] line : map) {
            for (char c : line) {
                System.out.print(c + " ");
            }
            System.out.println();
        }

        System.out.println(minTime == 0 ? "KAKTUS" : minTime);
    }


    // 물 확장
    private static void expendWater(Point v) {
        visited[v.x][v.y] = true;
        // 4방으로 물 확장
        for (int i = 0; i < 4; i++) {

            int nx = v.x + dx[i];
            int ny = v.y + dy[i];

            // 아직 물이 차지 않았고, 다음 확장 위치가 비버집이나 돌이 아니라면,
            if (isIn(nx, ny) && !visited[nx][ny]) {
                if (map[nx][ny] == '.') {
                    map[nx][ny] = '*';
                    visited[nx][ny] = true;
                    water.add(new Point(nx, ny));

                    System.out.println("물 확장 중");
                    for (char[] line : map) {
                        for (char c : line) {
                            System.out.print(c + " ");
                        }
                        System.out.println();
                    }
                }
            }
        }
    }

    // 고슴도치 이동
    private static void move(Point v){

        visited[v.x][v.y] = true;

        // 4방으로 물 확장
        for (int i = 0; i < 4; i++) {

            int nx = v.x + dx[i];
            int ny = v.y + dy[i];

            // 아직 물이 차지 않았고, 다음 확장 위치가 비버집이나 돌이 아니라면,
            if (isIn(nx, ny) && !visited[nx][ny]) {

                // 비버집에 도달했다면
                if(map[nx][ny] == 'D'){
                    return;
                }

                // 갈 수 있는 길이라면
                if (map[nx][ny] == '.') {
                    visited[nx][ny] = true;
                    location.add(new Point(nx, ny));

                    System.out.println("고슴도치 이동 중");
                    for (char[] line : map) {
                        for (char c : line) {
                            System.out.print(c + " ");
                        }
                        System.out.println();
                    }
                }
            }
        }
    }

    // 탐색
    // x, y는 현재 위치
    private static void search(int x, int y) {

        while(true) {

            // 1초 증가
            time++;

            // 물 확장
            int loop = water.size();
            for (int i = 0; i < loop; i++) {
                expendWater(water.remove(0));
            }

            // 고슴도치 이동
            loop = location.size();
            for (int i = 0; i < loop; i++) {
                move(location.remove(0));
            }
        }
    }


    // 범위 체크
    private static boolean isIn(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    // 좌표 클래스
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
