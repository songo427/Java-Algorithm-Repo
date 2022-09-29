package sw.expert.academy.exam1953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1953. [모의 SW 역량테스트] 탈주범 검거
 * 송현주
 */

public class Solution1953H {

    static class Point {
        int x, y;
        ArrayList<Integer> dirs;

        Point(int x, int y, ArrayList<Integer> dirs) {
            this.x = x;
            this.y = y;
            this.dirs = dirs;
        }
    }


    static StringBuilder answer;
    static int N, M, R, C, L;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상 - 하 - 좌 - 우

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        answer = new StringBuilder();
        for (int testCase = 1; testCase <= T; testCase++) {

            // 정답
            answer.append("# " + testCase + " ");

            // 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 세로 크기
            M = Integer.parseInt(st.nextToken()); // 가로 크기
            R = Integer.parseInt(st.nextToken()); // 맨홀 뚜껑 Row
            C = Integer.parseInt(st.nextToken()); // 맨홀 뚜껑 Column
            L = Integer.parseInt(st.nextToken()); // 탈출 후 경과 시간

            // map 생성 및 방문 여부 저장 배열 생성
            map = new int[N][M];
            visited = new boolean[N][M];

            // 맵 생성
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            // 탐색 - 맨홀 위치를 기준으로
            visited[R][C] = true;
            bfs(new Point(R, C, setDir(R, C)));

        }

        System.out.print(answer.toString().trim());
    }

    // 탐색 방향 찾기
    private static ArrayList<Integer> setDir(int x, int y) {

        // 현재 지점 방향 저장
        int currentDir = map[x][y];
        ArrayList<Integer> dirs = new ArrayList<>();

        switch (currentDir) {
            case 1: // 상 - 하 - 좌 - 우 이동
                dirs.add(0);
                dirs.add(1);
                dirs.add(2);
                dirs.add(3);
                break;
            case 2: // 상 - 하 이동
                dirs.add(0);
                dirs.add(1);
                break;
            case 3: // 좌 - 우 이동
                dirs.add(2);
                dirs.add(3);
                break;
            case 4: // 상 - 우 이동
                dirs.add(0);
                dirs.add(3);
                break;
            case 5: // 우 - 하
                dirs.add(3);
                dirs.add(1);
                break;
            case 6: // 좌 - 하 이동
                dirs.add(2);
                dirs.add(1);
                break;
            case 7: // 상 - 좌 이동
                dirs.add(0);
                dirs.add(2);
                break;
            default:
                break;
        }
        return dirs;
    }

    // 해당 방향으로 탐색
    private static void bfs(Point point) {

        int cnt = 1;
        Queue<Point> queue = new ArrayDeque<>();
        Queue<Point> tmp = new ArrayDeque<>(); // queue 요소에서 갈 수 있는 점 저장
        queue.add(point);

        while (L > 1) {

            while (!queue.isEmpty()) {

                Point current = queue.poll();

                for (int idx : current.dirs) {

                    int nx = current.x + dirs[idx][0];
                    int ny = current.y + dirs[idx][1];

                    // 갈 수 있는지 확인
                    if (!isIn(nx, ny) || map[nx][ny] == 0 || visited[nx][ny]) continue;
                    Point next = new Point(nx, ny, setDir(nx, ny));

                    // 다음 파이프와 연결여부 확인
                    if (!isConnected(idx, next)) continue;

                    // 저장
                    tmp.add(next);
                    visited[nx][ny] = true;
                    cnt++;
                }
            }

            queue.addAll(tmp);
            tmp.clear();
            L--;
        }
        answer.append(cnt + "\n");
    }

    // 현재 파이프와 이동할 파이프가 연결되어 있는지 확인
    private static boolean isConnected(int idx, Point next) {

        // 홀수번(1,3)이면 -1과 연결되어야 함
        if (idx % 2 == 1) {
            if (next.dirs.contains(idx - 1)) {
                return true;
            }
        } else {
            if (next.dirs.contains(idx + 1)) {
                return true;
            }
        }
        return false;
    }

    // 범위 확인
    private static boolean isIn(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < M;
    }
}
