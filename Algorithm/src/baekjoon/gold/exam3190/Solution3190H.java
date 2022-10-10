package baekjoon.gold.exam3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 3190. 뱀
 * 송현주
 */
public class Solution3190H {


    // 좌표를 저장할 클래스
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 전환 시간과 방향을 저장할 클래스
    static class TurningPoint {
        int time;
        char dir;

        public TurningPoint(int time, char dir) {
            this.time = time;
            this.dir = dir;
        }
    }

    static boolean isEnd; // 게임이 끝났는지 여부 저장
    static int answer, N;
    static int[][] map;
    static TurningPoint[] info; // 방향 전환 정보 저장
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상 - 하 - 좌 - 우
    static Deque<Point> dequeue; // 뱀의 몸의 길이 저장
    static Point snakePoint; // 뱀의 마지막 위치 좌표

    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine()); // 칸의 수
        int appleCnt = Integer.parseInt(br.readLine()); // 사과의 수

        // 맵 생성
        map = new int[N + 1][N + 1]; // 생성

        // 뱀 위치 설정
        map[1][1] = 1; // snake : 1

        // 사과 위치 설정
        for (int i = 0; i < appleCnt; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 2; // apple : 2
        }

        // 뱀의 전환 정보 저장
        int cnt = Integer.parseInt(br.readLine());
        info = new TurningPoint[cnt];

        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            info[i] = new TurningPoint(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
        }

        // 현재 뱀의 머리 좌표와 방향 저장
        dequeue = new ArrayDeque<>();
        // 뱀 좌표 초기화
        snakePoint = new Point(1, 1);
        dequeue.add(snakePoint);
        int dir = 3; // 시작은 오른쪽부터


        // 방향 전환 시간만큼 움직임
        int prevTime = 0; // 누적 시간
        for (int i = 0; i < cnt; i++) {
            if (isEnd) break;
            moveSnake(info[i].time, prevTime, dir);
            prevTime = info[i].time;
            dir = rotateDir(dir, info[i].dir); // 방향 전환
        }

        // 게임이 끝나지 않았다면,
        if (!isEnd) {
            // 범위 안에서 갈 수 있는 만큼 끝까지 이동
            while (isIn(snakePoint.x, snakePoint.y)) {
                snakePoint.x = snakePoint.x + dirs[dir][0];
                snakePoint.y = snakePoint.y + dirs[dir][1];
                answer++;

                // 뱀의 몸에 부딪힌다면 종료!
                if (map[snakePoint.x][snakePoint.y] == 1) break;
            }
        }
        System.out.print(answer);
    }

    // 방향을 바꾸기 위한 메서드
    private static int rotateDir(int prev, char dir) {

        // 왼쪽
        if (dir == 'L') {
            int[] lDir = {2, 3, 1, 0};
            return lDir[prev];
        } else { // 오른쪽
            int[] rDir = {3, 2, 0, 1};
            return rDir[prev];
        }
    }

    // 뱀 이동
    private static void moveSnake(int time, int prevTime, int dir) {

        int tmp = time - prevTime; // 진행해야하는 시간 - 이전 시간
        int nx = -1, ny = -1; // 초기화

        // 시간동안 이동
        while (tmp-- > 0) {

            // 현재 머리 위치를 가져옴
            Point current = dequeue.peekLast();
            nx = current.x + dirs[dir][0];
            ny = current.y + dirs[dir][1];


            // 뱀이 벽을 만나거나 자신의 몸(1)과 만나면 종료
            if (!isIn(nx, ny) || map[nx][ny] == 1) {
                answer++;
                isEnd = true;
                return;
            }

            // 다음칸에 사과가 없다면
            if (map[nx][ny] != 2) {
                // 사과가 없다면, 꼬리 위치 칸을 비워줌 1 -> 0
                Point tail = dequeue.pollFirst();
                map[tail.x][tail.y] = 0;
            }

            dequeue.add(new Point(nx, ny));
            map[nx][ny] = 1;
            answer++;
        }

        // 뱀의 마지막 위치 저장
        snakePoint.x = nx;
        snakePoint.y = ny;
    }

    // 범위 확인 (1부터 N사이 범위 내에 존재하는지 확인)
    private static boolean isIn(int nx, int ny) {
        return nx >= 1 && ny >= 1 && nx <= N && ny <= N;
    }
}