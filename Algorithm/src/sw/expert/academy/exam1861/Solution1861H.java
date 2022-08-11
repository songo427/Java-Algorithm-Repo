package sw.expert.academy.exam1861;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1861. 정사각형 방
 * 송현주
 */
public class Solution1861H {
    static int[][] room; // 방 번호 들어 있는 배열
    static int[][] distance; // 각 방에서 갈 수 있는 최대 거리 저장

    // 상 하 좌 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());

            int[][] square = new int[N][N];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                StringTokenizer tokenizer = new StringTokenizer(line);
                for (int j = 0; j < N; j++) {
                    square[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            int x = 0;
            int y = 0;
            int idx = 0;

            // 2중 for문
            boolean[][] isVisited = new boolean[N][N];
            // 재귀 함수 사용

            System.out.println(Arrays.deepToString(square));
        }
    }

    private static void go(int x, int y) {
        distance[x][y] = 1;// 시작지점 방문

        for (int i = 0; i < 4; i++) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!isIn(nx, ny)) continue;
        }
    }

    private static boolean isIn(int nx, int ny) {
        return (nx >= 0 && ny >= 0 && nx < N && ny < N);
    }
}
