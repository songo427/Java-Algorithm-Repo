package baekjoon.silver.exam4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 4963. 섬의 개수
 * 송현주
 */
public class Solution4963H {

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int w, h, answer;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}}; // 상 - 하 - 좌 - 우 - 우하 - 우상 - 좌하 - 좌상

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            // 입력
            String input = br.readLine();

            // 기저 조건
            if (input.equals("0 0")) break;

            // 초기화
            answer = 0;
            StringTokenizer st = new StringTokenizer(input);
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new int[h][w];
            visited = new boolean[h][w];

            // 지도 생성
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 지도 탐색
            for (int x = 0; x < h; x++) {
                for (int y = 0; y < w; y++) {
                    if (visited[x][y] || map[x][y] == 0) continue;
                    dfs(new Point(x, y));
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }

    // dfs 탐색
    private static void dfs(Point current) {

        // 시작점 방문체크
        visited[current.x][current.y] = true;

        // 8방 탐색
        for (int i = 0; i < 8; i++) {

            // 탐색할 좌표 생성
            int nx = current.x + dirs[i][0];
            int ny = current.y + dirs[i][1];

            // 탐색 조건
            if (!isIn(nx, ny) || visited[nx][ny]) continue;
            if (map[nx][ny] == 0) continue;

            // 탐색
            dfs(new Point(nx, ny));
        }
    }

    // 범위 확인
    private static boolean isIn(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < h && ny < w;
    }
}
