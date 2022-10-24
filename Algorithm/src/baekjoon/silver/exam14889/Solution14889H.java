package baekjoon.silver.exam14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 14889. 스타트와 링크
 * 송현주
 */
public class Solution14889H {
    static int N, answer;
    static int[][] ability;
    static int[] startTeam;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 능력치 저장
        ability = new int[N][N];
        startTeam = new int[N / 2];
        answer = Integer.MAX_VALUE;

        // 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 조합 시작
        comb(0, 0);
        System.out.println(answer);
    }


    // 조합
    private static void comb(int start, int cnt) {

        // 총 N의 이등분 만큼 조합
        if (N / 2 == cnt) {
            compareToAbilities(startTeam);
            return;
        }

        for (int i = start; i < N; i++) {
            // startTeam의 i번째 선수 선택
            startTeam[cnt] = i;
            comb(i + 1, cnt + 1);
        }
    }

    // 능력치 합 비교
    private static void compareToAbilities(int[] startTeam) {

        // 선수들 저장
        boolean[] players = new boolean[N];

        // 각 팀의 능력치 합 저장
        int start = 0;
        int link = 0;

        // 선수 팀 배정
        for (int idx = 0; idx < N / 2; idx++) {
            players[startTeam[idx]] = true;
        }

        // 합 계산
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {

                // 스타트 팁 능력치
                if (players[i] && players[j]) {
                    start += ability[i][j] + ability[j][i];
                }

                // 링크 팀 능력치
                if(!players[i] && !players[j]){
                    link += ability[i][j] + ability[j][i];
                }
            }
        }

        // 팁 조합 차가 적은 값으로 갱신
        answer = Math.min(answer, Math.abs(start - link));
    }
}
