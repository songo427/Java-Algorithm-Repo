package baekjoon.gold.exam17144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 안녕 미세먼지!
public class Solution17144H {
    static class Dust {
        public int x, y;
        public int amount;

        public Dust(int x, int y, int amount) {
            this.x = x;
            this.y = y;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "Dust{" +
                    "x=" + x +
                    ", y=" + y +
                    ", amount=" + amount +
                    '}';
        }
    }

    // 행, 열, 시간
    static int R, C, T;

    // 상 하 좌 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 방 정보
    static int[][] room;
    static List<Dust> dustList;
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
        dustList = new ArrayList<>();
        visited = new boolean[R + 1][C + 1];
        rowIdxs = new ArrayList<>();

        for (int i = 1; i <= R; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= C; j++) {
                room[i][j] = Integer.parseInt(tokenizer.nextToken());
                if (room[i][j] != -1 && room[i][j] != 0) {
                    dustList.add(new Dust(i, j, room[i][j]));
                }
                // 공기 청정기의 행 좌표만 저장
                if (room[i][j] == -1) {
                    rowIdxs.add(i);
                }
            }
        }



        int time = 0;
        while (time < T) {
            spreadDust();
            //System.out.println(dustList);
            System.out.println("확산된 배열: ");
            printArr(room);
            operateAirPurifier();
            System.out.println("공기청정기 가동: ");
            printArr(room);
            time++;
        }

        System.out.println(sumOfArray(room));
    }

    // 미세먼지 확산
    private static void spreadDust() {

        List<Dust> nDustList = new ArrayList<>();
        int size = dustList.size();

        // 미세먼지가 있는 곳만 탐색
        for (int i = 0; i < size; i++) {

            // 미세먼지 꺼내기
            Dust dust = dustList.remove(0);

            int cnt = 0;
            int amount = dust.amount / 5;
            //System.out.println("먼지양 : " + dust.amount + " 나눌 먼지양: " + amount);

            for (int k = 0; k < 4; k++) {
                int nx = dust.x + dx[k];
                int ny = dust.y + dy[k];

                if (!isIn(nx, ny) || room[nx][ny] == -1) continue;

                //System.out.println("room[" + nx + "][" + ny + "] = " + room[nx][ny] + "+" + amount);
                room[nx][ny] += amount;

                // 문제
                // nDustList.add(new Dust(nx, ny, room[nx][ny]));
                cnt++;
            }

            // 확산된 영역이 몇개 인지
            if (cnt != 0) {
                room[dust.x][dust.y] -= dust.amount;
                room[dust.x][dust.y] += dust.amount - (dust.amount / 5) * cnt;
                nDustList.add(new Dust(dust.x, dust.y, room[dust.x][dust.y]));
            }

            //System.out.println("(" + dust.x + "," + dust.y + ") 확산 완료: ");
            printArr(room);
        }
        dustList = nDustList;
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

        // 공기 청정기에서 부는 바람은 미세먼지가 없는 바람
        room[x][y] = 0;
        while (true) {

            if ( x == rowIdxs.get(0) && y == 1){
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

        // 공기 청정기에서 부는 바람은 미세먼지가 없는 바람
        room[x][y] = 0;
        while (true) {

            if ( x == rowIdxs.get(1) && y == 1){
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
    private static int sumOfArray(int[][] arr){
        int sum = 0;
        for(int i=1; i<=R; i++){
            for(int j=1; j<=C; j++){
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
