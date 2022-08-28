package baekjoon.gold.exam17144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 안녕 미세먼지!
public class Solution17144H {
    // 행, 열, 시간
    static int R, C, T;

    // 상 하 좌 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 방 정보
    static int[][] room;
    static boolean[][] visited;
    static List<Integer> rowIdxs;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        // 입력
        R = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());
        T = Integer.parseInt(tokenizer.nextToken());

        // 1부터 시작
        room = new int[R + 1][C + 1];
        visited = new boolean[R + 1][C + 1];
        rowIdxs = new ArrayList<>();

        for (int i = 1; i <= R; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= C; j++) {
                room[i][j] = Integer.parseInt(tokenizer.nextToken());
                // 공기 청정기의 행 좌표만 저장
                if (room[i][j] == -1) {
                    rowIdxs.add(i);
                }
            }
        }


        int time = 0;
        while (time < T) {
            spreadDust();
            operateAirPurifier();
            time++;
        }
        System.out.println(sumOfArray(room));
    }

    // 미세먼지 확산
    private static void spreadDust() {

        int[][] spreadArea = new int[R + 1][C + 1];

        // 미세먼지가 있는 곳만 탐색
        for (int x = 1; x <= R; x++) {
            for (int y = 1; y <= C; y++) {

                if (room[x][y] == 0) continue;

                int cnt = 0;
                int amount = room[x][y] / 5;

                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if (!isIn(nx, ny) || room[nx][ny] == -1) continue;

                    // 추가되는 미세먼지양만 저장
                    spreadArea[nx][ny] += amount;
                    cnt++;
                }

                // 기존 미세먼지는 감소
                room[x][y] = room[x][y] - (room[x][y] / 5) * cnt;
            }
        }

        // 복사
        for (int x = 1; x <= R; x++) {
            for (int y = 1; y <= C; y++) {
                if (spreadArea[x][y] == 0) continue;
                room[x][y] += spreadArea[x][y];
            }
        }
    }

    // 공기청정기 작동
    private static void operateAirPurifier() {

        // 반시계 방향 회전
        rotateReverse();

        // 시계 방향 회전
        rotate();
    }

    // 반시계 방향 회전
    private static void rotateReverse() {
        int[] rx = {0, -1, 0, 1};
        int[] ry = {1, 0, -1, 0};

        // 공기 청정기 보다 1만큼 앞
        int x = rowIdxs.get(0);
        int y = 2;
        int dir = 0;
        int cur = room[x][y];
        room[x][y] = 0;

        while (true) {

            if (x == rowIdxs.get(0) && y == 1) {
                room[x][y] = -1;
                return;
            }
            int nx = x + rx[dir];
            int ny = y + ry[dir];

            if (!isIn(nx, ny)) {
                dir = (dir + 1) % 4;
                nx = x + rx[dir];
                ny = y + ry[dir];
            }

            int next = room[nx][ny];
            room[nx][ny] = cur;
            cur = next;

            x = nx;
            y = ny;

//            System.out.println("반시계 방향 이동 중!");
//            System.out.println("room["+x+"]["+y+"] = " + room[x][y]);
//            System.out.println("room["+nx+"]["+ny+"] = " + room[nx][ny]);
//            printArr(room);
        }
    }

    private static void rotate() {

        // 우 - 하 - 좌 - 상
        int[] rx = {0, 1, 0, -1};
        int[] ry = {1, 0, -1, 0};

        // 공기 청정기 보다 1만큼 앞
        int x = rowIdxs.get(1);
        int y = 2;
        int dir = 0;
        int cur = room[x][y];
        room[x][y] = 0;

        while (true) {

            if (x == rowIdxs.get(1) && y == 1) {
                room[x][y] = -1;
                return;
            }
            int nx = x + rx[dir];
            int ny = y + ry[dir];

            if (!isIn(nx, ny)) {
                dir = (dir + 1) % 4;
                nx = x + rx[dir];
                ny = y + ry[dir];
            }

            int next = room[nx][ny];
            room[nx][ny] = cur;
            cur = next;

            x = nx;
            y = ny;

//            System.out.println("시계 방향 이동 중!");
//            System.out.println("room["+x+"]["+y+"] = " + room[x][y]);
//            System.out.println("room["+nx+"]["+ny+"] = " + room[nx][ny]);
//            printArr(room);
        }
    }

    // 범위 확인
    private static boolean isIn(int nx, int ny) {
        return nx > 0 && ny > 0 && nx <= R && ny <= C;
    }

    // 배열 전체의 합
    private static int sumOfArray(int[][] arr) {
        int sum = 0;
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                sum += arr[i][j];
            }
        }
        return sum + 2;
    }

    // 배열 출력
    private static void printArr(int[][] arr) {

        for (int[] line : arr) {
            for (int num : line) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
        System.out.println("====================================");
    }
}
