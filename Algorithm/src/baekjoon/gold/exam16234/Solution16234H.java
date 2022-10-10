package baekjoon.gold.exam16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 16234. 인구 이동
 * 송현주
 */
public class Solution16234H {

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, L, R;
    static int[][] land;
    static boolean[][] visited;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상 - 하 - 좌 - 우

    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 땅의 크기
        L = Integer.parseInt(st.nextToken()); // 최소 인구수
        R = Integer.parseInt(st.nextToken()); // 최대 인구수

        // 생성
        land = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        boolean isStop = false;

        // 국경선을 공유하고 있는 나라 수
        while (true) {

            // 국경을 공유할 수 있는 나라가 하나라도 있다면 계속 진행
            loop:
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {

                    // 4방 탐색
                    for (int i = 0; i < 4; i++) {
                        int nx = x + dirs[i][0];
                        int ny = y + dirs[i][1];

                        if (!isIn(nx, ny)) continue;
                        if (isShareBorderline(land[x][y], land[nx][ny])) {
                            break loop;
                        }
                    }

                    // 찾지 못했다면
                    if (x == N - 1 && y == N - 1) {
                        isStop = true;
                    }
                }
            }

            // 더 이상 인구 이동이 불가능한다면, 종료
            if (isStop) break;

            // 탐색 전 초기화
            visited = new boolean[N][N];

            // 국경선을 공유하는 나라가 있는지 탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) continue;
                    bfs(new Point(i, j));
                }
            }

            answer ++;
        }
        System.out.print(answer);
    }


    // 국경선을 공유하는 나라가 있는지 탐색
    private static void bfs(Point start) {

        // 첫번째 탐색이 default
        ArrayList<Point> neighboringCountries = new ArrayList<>();
        neighboringCountries.add(start);

        Queue<Point> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {

            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {

                int nx = current.x + dirs[i][0];
                int ny = current.y + dirs[i][1];

                if (!isIn(nx, ny) || visited[nx][ny]) continue;

                // 연합국이라면
                if (isShareBorderline(land[current.x][current.y], land[nx][ny])) {
                    queue.add(new Point(nx, ny));
                    neighboringCountries.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }

        // 가능한 경우 탐색 완료 후, 연합국의 인구수 갱신
        if (neighboringCountries.size() > 1) {
            updatePopulation(neighboringCountries);
        }

    }

    // 연합한 나라의 인구수 갱신
    private static void updatePopulation(ArrayList<Point> neighboringCountries) {

        // 연합국의 인구수 합
        int avg = 0;
        for (Point point : neighboringCountries) {
            avg += land[point.x][point.y];
        }

        // 평균
        avg /= neighboringCountries.size();

        // 갱신
        for (Point point : neighboringCountries) {
            land[point.x][point.y] = avg;
        }
    }


    // 탐색 범위 확인
    private static boolean isIn(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < N;
    }

    // 공유할 수 있는지 인구수 범위 계산
    private static boolean isShareBorderline(int population1, int population2) {
        return L <= Math.abs(population1 - population2) && R >= Math.abs(population2 - population1);
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
