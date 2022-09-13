package baekjoon.silver.exam2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2468. 안전 영역
 * 송현주
 */
public class Solution2468H {
    static int N, maxCount;
    static int[][] map;
    static int[][] deltaXY = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상 - 하 - 좌 - 우
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int start = 101;
        int end = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 최소, 최대 찾기
                start = Math.min(map[i][j], start);
                end = Math.max(map[i][j], end);
            }
        }

        // 높이 만큼 반복
        for (int height = start; height <= end; height++) {
            // 높이마다 초기화
            int count = 0;
            visited = new boolean[N][N];

            // 탐색
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if (!visited[x][y] && map[x][y] > height) {
                        dfs(x, y, height);
                        count++;
                    }
                }
            }
            // 최대 값 확인
            if (maxCount < count) maxCount = count;
        }
        // 잠기지 않는 경우 체크
        System.out.print(maxCount == 0 ? 1 : maxCount);
    }

    private static void dfs(int x, int y, int height) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + deltaXY[i][0];
            int ny = y + deltaXY[i][1];

            // 범위를 벗어나거나 최소 높이 보다 작을 경우 탐색 X
            if (!isIn(nx, ny) || visited[nx][ny] || map[nx][ny] <= height) continue;
            dfs(nx, ny, height);
        }
    }

    // 범위 체크
    private static boolean isIn(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < N;
    }
}

