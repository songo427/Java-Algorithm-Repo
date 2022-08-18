package sw.expert.academy.d4.exam1210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 1210. [S/W 문제해결 기본] 2일차 - Ladder1
 * 이다은
 */
public class Solution1210D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 아래, 좌, 우
        int[] dx = {1, 0, 0};
        int[] dy = {0, -1, 1};

        for (int i = 0; i < 10; i++) {
            int T = Integer.parseInt(reader.readLine());
            int[][] ladder = new int[102][102];

            for (int j = 1; j < 101; j++) {
                StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
                for (int k = 1; k < 101; k++) {
                    ladder[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int idx = 0;
            int answer = 0;
            for (int j = 1; j < 101; j++) {
                if (ladder[1][j] == 1) {
                    int x = 1;
                    int y = j;
                    while (true) {
                        if (idx == 0) {
                            if (ladder[x+dx[1]][y+dy[1]] == 1) {
                                idx = 1;
                            } else if (ladder[x+dx[2]][y+dy[2]] == 1) {
                                idx = 2;
                            }
                        } else {
                            if (ladder[x+dx[0]][y+dy[0]] != 0) {
                                idx = 0;
                            }
                        }

                        x += dx[idx];
                        y += dy[idx];

                        if (x == 100) {
                            break;
                        }
                    }
                    if (ladder[x][y] == 2) {
                        answer = j-1;
                    }
                }
            }

            System.out.println("#" + T + " " + answer);

        }
    }

}
