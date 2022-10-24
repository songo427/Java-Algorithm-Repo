package baekjoon.silver.exam1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 14501. 체스판 다시 칠하기
 * 송현주
 */

public class Solution1018H {

    static boolean[][] chess, startOfWhite, startOfBlack;

    static int N, M, minCnt, answer;

    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 초기 설정
        makeDefaultChess();
        answer = Integer.MAX_VALUE;

        // 체스판 생성
        chess = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                // W는 true, B는 false로 저장
                if (line[j] == 'W') chess[i][j] = true;
                else chess[i][j] = false;
            }
        }

        // 현재 위치 기준 탐색 - 8칸 탐색이 가능한 지점만
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                search(i, j);
                answer = Math.min(answer, minCnt);
            }
        }

        // 출력
        System.out.println(answer);
    }

    // 탐색
    private static void search(int x, int y) {

        // 임시 저장
        int white = 0;
        int black = 0;

        // 8개 범위내에 존재하는지 확인 - 8칸을 못만든다면 리턴
        if (x + 7 >= N || y + 7 >= M) return;

        // 탐색
        for (int i = x; i <= x + 7; i++) {
            for (int j = y; j <= y + 7; j++) {
                if (startOfWhite[i - x][j - y] == chess[i][j]) white++;
                if (startOfBlack[i - x][j - y] == chess[i][j]) black++;
            }
        }

        // 더 작은 값으로 갱신
        minCnt = Math.min(white, black);

    }


    // 시작컬러에 대한 기본 체스판 생성
    private static void makeDefaultChess() {

        boolean flag = true;

        startOfWhite = new boolean[8][8];
        startOfBlack = new boolean[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                startOfWhite[i][j] = flag;
                startOfBlack[i][j] = !flag;

                flag = !flag; // 다음 칸은 반대
            }
            flag = !flag; // 다음 칸은 반대
        }
    }
}
