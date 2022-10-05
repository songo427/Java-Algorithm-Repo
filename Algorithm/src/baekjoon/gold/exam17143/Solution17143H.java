package baekjoon.gold.exam17143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 낚시왕
public class Solution17143H {

    // 상어 정보를 갖는 클래스
    static class Shark {
        int r, c; // 현재 상어 위치 좌표
        int s; // 상어의 속력
        int d; // 상어의 이동 방향
        int z; // 상어의 크기

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    static int R, C, M, answer; // 행, 열, 상어의 수
    static Shark[][] map; // 낚시 하는 곳


    static int[][] dirs = {{0, 0}, {-1, 0}, {1, 0}, {0, 1}, {0, -1}}; // 상 - 하 - 우 - 좌

    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // map을 생성한다.
        map = new Shark[R + 1][C + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 상어를 배치한다.
            map[r][c] = new Shark(r, c, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // 낚시 왕은 오른쪽으로 한 칸씩 이동한다. (마지막 컬럼에 도착할 때까지 반복)
        for (int column = 1; column <= C; column++) {
            fishShark(column);
            map = moveShark();
        }

        System.out.println(answer);
    }

    // 낚시왕 낚시 시작! - 현재 컬럼 위치를 전달한다.
    private static void fishShark(int current) {
        // 가장 가까운 위치의 상어를 잡고 제거한다.
        for (int i = 1; i <= R; i++) {
            if (map[i][current] != null) {
                answer += map[i][current].z;
                map[i][current] = null;
                return;
            }
        }
    }

    // 상어가 이동 시작!
    private static Shark[][] moveShark() {

        // 이동한 상어들을 담을 공간
        Shark[][] nMap = new Shark[R + 1][C + 1];

        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {

                // 현재 위치에 상어가 존재한다면,
                if (map[r][c] != null) {

                    // 이동할 상어 정보
                    Shark shark = map[r][c];

                    // 이동 하기 전 상어 제거
                    map[r][c] = null;

                    // 좌표 설정
                    int nr = r + dirs[shark.d][0] * shark.s;
                    int nc = c + dirs[shark.d][1] * shark.s;
                    int nDir = shark.d;

                    // 범위를 벗어날 경우 새로운 좌표
                    while (!isIn(nr, nc)) {
                        if (nr < 1) { // 상 -> 하
                            nDir = 2;
                            nr = Math.abs(nr - 2);
                        } else if (nr >= R + 1) { // 하 -> 상
                            nDir = 1;
                            int tmp = nr - R;
                            nr -= tmp * 2;
                        } else if (nc < 1) { // 좌 -> 우
                            nDir = 3;
                            nc = Math.abs(nc - 2);
                        } else if (nc >= C + 1) { // 우 -> 좌
                            nDir = 4;
                            int tmp = nc - C;
                            nc -= tmp * 2;
                        }
                    }

                    // 바뀐 방향 세팅
                    shark.d = nDir;

                    // 새로운 위치에 상어 추가
                    // 다른 상어가 이미 들어와있다면 큰놈이 먹는다.
                    if (nMap[nr][nc] != null) {
                        if (nMap[nr][nc].z < shark.z) {
                            nMap[nr][nc] = shark;
                        }
                    } else {
                        nMap[nr][nc] = shark;
                    }
                }
            }
        }
        return nMap;
    }


    // 범위 확인 (1부터 R, C까지)
    private static boolean isIn(int nr, int nc) {
        return nr >= 1 && nc >= 1 && nr <= R && nc <= C;
    }
}

