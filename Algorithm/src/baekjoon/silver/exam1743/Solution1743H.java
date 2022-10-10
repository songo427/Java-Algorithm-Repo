package baekjoon.silver.exam1743;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1743. 음식물 피하기
 * 송현주
 */

public class Solution1743H {

    // 좌표를 저장할 클래스
    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, M, K;
    static int[][] graph;
    static boolean[][] visited;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상 - 하 - 좌 - 우

    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열
        K = Integer.parseInt(st.nextToken()); // 쓰레기의 수

        // 생성
        graph = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[r][c] = 1; // 쓰레기는 1로 처리
        }

        // 탐색
        int maxSize = Integer.MIN_VALUE;
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= M; c++) {
                if (graph[r][c] == 0 || visited[r][c]) continue;

                // 사이즈가 크다면 갱신
                maxSize = Math.max(maxSize, bfs(new Point(r, c)));
            }
        }
        System.out.println(maxSize);
    }

    // 탐색
    private static int bfs(Point start) {

        // 현재 쓰레기 사이즈 = 1
        int size = 1;

        // 현재 쓰레기 queue에 추가 및 방문 체크
        Queue<Point> queue = new ArrayDeque<>();
        visited[start.r][start.c] = true;
        queue.add(start);

        while (!queue.isEmpty()) {

            // 현재 쓰레기 탐색
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {

                // 새 위치 좌표 생성
                int nr = current.r + dirs[i][0];
                int nc = current.c + dirs[i][1];

                if (!isIn(nr, nc) || visited[nr][nc]) continue; // 방문 할 수 없다면 continue

                // 인접한 위치에 쓰레기가 존재한다면 queue에 추가
                if (graph[nr][nc] == 1) {
                    queue.add(new Point(nr, nc));
                    visited[nr][nc] = true;
                    size++;
                }
            }
        }

        return size;
    }


    // 범위 확인
    private static boolean isIn(int nx, int ny) {
        return nx >= 1 && ny >= 1 && nx <= N && ny <= M;
    }
}
