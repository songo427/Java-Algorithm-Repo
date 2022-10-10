package baekjoon.gold.exam2589;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 2589. 보물섬
 * 송현주
 */
public class Solution2589H {

    static class Point {
        int x, y;
        int time = 0;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상 - 하 - 좌 - 우

    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 생성
        map = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            map[i] = line;
        }

        int answer = 0;
        // 모든 육지에 대해 bfs 탐색
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {

                // 바다라면 continue
                if (map[x][y] == 'W') continue;

                // 육지라면 탐색
                visited = new boolean[N][M]; // 초기화
                answer = Math.max(answer, bfs(new Point(x, y)));
            }
        }
        System.out.print(answer);
    }

    private static int bfs(Point start) {

        // 시간 초기화
        int time = 0;

        // 시작 위치 큐에 저장
        Queue<Point> queue = new ArrayDeque<>();
        visited[start.x][start.y] = true;
        queue.add(start);

        while (!queue.isEmpty()) {

            Point current = queue.poll();

            // 4방 탐색
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dirs[i][0];
                int ny = current.y + dirs[i][1];

                if (!isIn(nx, ny) || visited[nx][ny]) continue;

                // 육지라면
                if (map[nx][ny] == 'L') {

                    // 한칸 이동한 것임으로 현재 위치에서 + 1
                    queue.add(new Point(nx, ny, current.time + 1));
                    visited[nx][ny] = true;
                    time = Math.max(time, current.time + 1);
                }
            }
        }

        return time;
    }

    // 범위 확인
    private static boolean isIn(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < M;
    }

    private static void print(char[][] arr) {
        for (char[] line : arr) {
            for (char c : line) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
