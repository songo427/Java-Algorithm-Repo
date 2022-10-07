package baekjoon.gold.exam3190;

import java.io.*;
import java.util.*;

/**
 * 3190. 뱀
 * 이다은
 */
public class Solution3190D {
    // 방향 배열
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Deque<int[]> snake;
    static boolean[][] board;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        int K = Integer.parseInt(reader.readLine());
        StringTokenizer st;

        // 각 칸에 뱀의 몸통이 있는 지 체크할 보드
        board = new boolean[N+1][N+1];

        // 사과 위치 저장
        boolean[][] apple = new boolean[N+2][N+2];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            apple[a][b] = true;
        }

        // 뱀의 이동경로 저장
        int L = Integer.parseInt(reader.readLine());
        int[][] move = new int[L][2];
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(reader.readLine());
            move[i][0] = Integer.parseInt(st.nextToken());
            move[i][1] = st.nextToken().equals("D") ? 1 : -1; // 오른쪽으로 회전이면 1, 왼쪽으로 회전이면 -1
        }


        // 뱀의 몸통을 저장하는 큐
        snake = new ArrayDeque<int[]>();
        int[] point = {1, 1};
        snake.offer(point);

        int time = 1;
        int moveIdx = 0;
        int directionIdx = 0;
        boolean flag = true;
        while (flag) {
            if (moveIdx < L && time > move[moveIdx][0]) {
                // 방향 인덱스 변경
                int nIdx = directionIdx + move[moveIdx][1];
                if (nIdx == 4) {
                    directionIdx = 0;
                } else if (nIdx == -1) {
                    directionIdx = 3;
                } else {
                    directionIdx = nIdx;
                }

                // 이동 인덱스 변경
                moveIdx++;
            }

            // 이동
            int[] temp = snake.peekLast();
            int[] nPoint = {temp[0] + dy[directionIdx], temp[1] + dx[directionIdx]};
            snake.offer(nPoint);

            if (isReachable()) {
                board[nPoint[0]][nPoint[1]] = true;
            } else {
                flag = false;
            }

            // 사과가 없으면 맨 뒤에 있는 몸통 하나 없애기
            if (apple[nPoint[0]][nPoint[1]]) {
                apple[nPoint[0]][nPoint[1]] = false;
            } else {
                int[] p = snake.poll();
                board[p[0]][p[1]] = false;
            }

            time++;

        }

        System.out.println(time-1);

    }

    // 뱀이 벽이나 몸통에 부딪혔는지 확인하는 메소드
    static boolean isReachable() {
        int[] p = snake.peekLast();
        if (p[0] == 0 || p[1] == 0 || p[0] > N || p[1] > N || board[p[0]][p[1]]) {
            return false;
        }
        return true;
    }

}
