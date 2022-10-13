package sw.expert.academy.exam2117;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2117H {

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, answer;
    static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하죄우
    static int[][] town;
    static boolean[][] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 마을 크기
            M = Integer.parseInt(st.nextToken()); // 한 집당 비용
            answer = 0; // 최대 집의 수 초기화

            // 마을 집 추가
            town = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    town[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 완전 탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    // 방문 배열 초기화 후에 탐색
                    visited = new boolean[N][N];
                    bfs(new Point(i, j));
                }
            }

            System.out.println("#" + testCase + " " + answer);
        }
    }

    // 탐색
    private static void bfs(Point start) {

        // k는 1부터 시작
        int k = 1;

        // 범위 내에 있는 집의 수 - 시작 위치에 집이 있다면 1부터 시작
        int cnt = town[start.x][start.y] == 1 ? 1 : 0;

        // 범위에 들어온 위치 좌표 저장 - 시작 위치 추가
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {

            // 회사에 손해가 없는 상황이라면 현재까지 탐색한 집와 max값 비교
            if (calcCost(k) <= cnt * M) {
                answer = Math.max(answer, cnt);
            }

            // 탐색 범위 설정
            int range = queue.size();

            // 운영 영역 크기 증가
            k++;

            // 범위 크기만큼만 탐색
            for (int i = 0; i < range; i++) {

                // 현재 탐색 지점
                Point current = queue.poll();

                // 4방 탐색
                for (int idx = 0; idx < 4; idx++) {

                    // 탐색할 새로운 좌표 생성
                    int nx = current.x + dirs[idx][0];
                    int ny = current.y + dirs[idx][1];

                    // 마을 범위를 벗어나거나 이미 탐색 범위 내에 존재한다면
                    if (!isIn(nx, ny) || visited[nx][ny])
                        continue;

                    // 현재 위치가 집이라면 카운팅
                    if (town[nx][ny] == 1)
                        cnt++;

                    // 추가 및 방문 처리
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }

    }

    // 범위 확인
    private static boolean isIn(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < N;
    }

    // 운영 비용 계산을 위한 메서드
    private static int calcCost(int k) {
        return k * k + (k - 1) * (k - 1);

    }
}
