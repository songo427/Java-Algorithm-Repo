package baekjoon.silver.exam2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 *  2178. 미로 탈출
 *  송현주
 * */
public class Solution2178H {

    // 좌표와 경로까지 가기 위한 칸의 수 저장할 클래스
    static class Point {
        int x, y, count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    // 4방 탐색
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] graph;
    static boolean[][] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                graph[i][j] = line[j] - '0';
            }
        }
        System.out.println(bfs(new Point(0, 0, 1)));
    }

    private static int bfs(Point point) {

        Queue<Point> queue = new ArrayDeque<>();

        // 시작 정점 방문 표시
        queue.offer(point);
        visited[point.x][point.y] = true;

        while (!queue.isEmpty()) {

            Point current = queue.poll();

            // 목표지에 도달하면 리턴
            if (current.x == N - 1 && current.y == M - 1) {
                return current.count;
            }

            for (int i = 0; i < 4; i++) {

                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                // 범위 체크
                if (!isIn(nx, ny)) continue;

                // 방문 가능하다면
                if (!visited[nx][ny] && graph[nx][ny] != 0) {
                    queue.offer(new Point(nx, ny, current.count + 1));
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}