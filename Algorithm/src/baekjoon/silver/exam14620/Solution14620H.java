package baekjoon.silver.exam14620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 14620. 꽃길
 * 송현주
 */
public class Solution14620H {

    static int[][] garden; // 화단
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상 - 하 - 좌 - 우
    static boolean[][] isSelected;
    static int N, minCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        garden = new int[N][N];
        isSelected = new boolean[N][N];

        // 가든 생성
        for (int line = 0; line < N; line++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                garden[line][i] = Integer.parseInt(st.nextToken());
            }
        }

        // 탐색 시작
        dfs(0, 0);
        System.out.print(minCost);
    }

    // dfs 탐색
    private static void dfs(int cnt, int cost) {

        // 세 개의 씨앗을 다 심었다면 비용 비교
        if (cnt == 3) {
            minCost = Math.min(minCost, cost);
            return;
        }

        // 꽃잎이 밖으로 나가면 죽게 됨으로 1부터 N-1까지 탐색
        for (int x = 1; x < N - 1; x++) {
            for (int y = 1; y < N - 1; y++) {

                // 이미 선택이 됐거나 꽃잎이 겹친다면 진행 x
                if (!isPossible(x, y)) continue;

                // 현재 위치 및 4방 선택
                isSelected[x][y] = true;
                setSelection(x, y, true);

                // 다음 위치 탐색
                dfs(cnt + 1, cost + calcCost(x, y));

                // 탐색 후, 선택 해제
                isSelected[x][y] = false;
                setSelection(x, y, false);
            }
        }
    }

    // 현재 위치를 중심으로 꽃을 심을 수 있는지 검사
    private static boolean isPossible(int x, int y) {

        if(isSelected[x][y]) return false;

        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            // 이미 선택된 영역(겹친 꽃잎)이 있다면 현재 위치 선택 할 수 없음으로 false
            if (isSelected[nx][ny]) return false;
        }
        return true;
    }

    // flag에 따라 선택 여부 설정
    private static void setSelection(int x, int y, boolean flag){

        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            isSelected[nx][ny] = flag;
        }
    }

    // 현재 위치 + 4방의 비용 계산
    private static int calcCost(int x, int y) {

        int costs = garden[x][y];
        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            costs += garden[nx][ny];
        }
        return costs;
    }
}