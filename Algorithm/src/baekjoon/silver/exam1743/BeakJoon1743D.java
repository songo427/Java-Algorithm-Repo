package baekjoon.silver.exam1743;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeakJoon1743D {
    static int N;
    static int M;

    static boolean[][] visited;
    static boolean[][] isDirty;

    // {상, 하, 좌, 우} 방향 전환
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    // 음식물 사이즈
    static int size;

    public static void main(String[] args) throws IOException {
        // 입력 받기, 각 변수 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1][M+1];
        isDirty = new boolean[N+1][M+1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            isDirty[r][c] = true;
        }

        int answer = 0;

        // 모든 칸을 이동하며 dfs 탐색
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                // 조건: (1) 음식물이 있어야 하고, (2) visited에 없어야 함
                if (isDirty[i][j] && !visited[i][j]) {
                    size = 0;
                    dfs(i, j);

                    // dfs 다 돌고 나서 max size 갱신하기
                    answer = Math.max(answer, size);
                }
            }
        }

        System.out.println(answer);

    }

    public static void dfs(int r, int c) {
        visited[r][c] = true;
        size++;

        // 상, 하, 좌, 우 방향으로 다음 노드 탐색
        for (int i = 0; i < 4; i++) {
            int nr = r + dy[i];
            int nc = c + dx[i];

            if (nr > 0 && nr <= N && nc > 0 && nc <= M && isDirty[nr][nc] && !visited[nr][nc]) {
                dfs(nr, nc);
            }
        }

    }
}
