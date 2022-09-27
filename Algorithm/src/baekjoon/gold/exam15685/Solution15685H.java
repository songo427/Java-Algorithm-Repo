package baekjoon.gold.exam15685;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 15685. 드래곤 커브
 * 송현주
 */
public class Solution15685H {

    static int[][] deltaRC = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}}; // 우 - 상 - 좌 - 하
    static boolean[][] isCurve;

    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 드래곤 커브의 수
        isCurve = new boolean[101][101];

        // 세대 생성 및 커브 지점 찾기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            Stack<Integer> dirs = makeGeneration(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            findCurve(r, c, dirs);
        }


        // 전체 탐색
        int answer = 0;
        for (int r = 0; r < 101; r++) {
            for (int c = 0; c < 101; c++) {

                if (!isCurve[r][c]) continue;
                if(isSquare(r,c)) answer++;
            }
        }

        System.out.print(answer);
    }

    // 시작점을 기준으로 n세대까지의 방향 정보 생성
    private static Stack<Integer> makeGeneration(int start, int generation) {

        // 방향 저장
        Stack<Integer> dirs = new Stack<>();
        dirs.add(start);

        // generation(세대)만큼 반복
        while (generation-- > 0) {
            for (int i = dirs.size() - 1; i >= 0; i--) {
                int next = (dirs.get(i) + 1) % 4;
                dirs.add(next);
            }
        }
        return dirs;
    }

    // 드래곤 커브인 지점 체크
    private static void findCurve(int startRow, int startColumn, Stack<Integer> dirs) {

        int r = startRow;
        int c = startColumn;
        isCurve[r][c] = true;

        for (int i = 0; i < dirs.size(); i++) {
            int nr = r + deltaRC[dirs.get(i)][0];
            int nc = c + deltaRC[dirs.get(i)][1];

             if (!isIn(nr, nc)) continue;

             if(isCurve[nr][nc]) {
                 r = nr;
                 c = nc;
                 continue;
             }

            isCurve[nr][nc] = true;
            r = nr;
            c = nc;
        }
    }

    // 주변 탐색 - 4각형이 되는지 확인
    private static boolean isSquare(int r, int c) {
        int[][] delta = {{0, 1}, {1, 0}, {1, 1}}; // 우 - 하 - 대각선
        for (int i = 0; i < 3; i++) {
            int nr = r + delta[i][0];
            int nc = c + delta[i][1];

            if(!isIn(nr, nc) || !isCurve[nr][nc]) return false;
        }
        return true;
    }


    // 범위 확인
    private static boolean isIn(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < 101 && ny < 101;
    }
}
