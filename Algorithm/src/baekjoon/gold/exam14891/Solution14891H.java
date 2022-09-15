package baekjoon.gold.exam14891;
/**
 * 14891. 톱니바퀴
 * 송현주
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution14891H {

    static int[][] gears;
    static int[] rotateDir;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gears = new int[4][8];
        for (int i = 0; i < 4; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                gears[i][j] = input[j] - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            rotateDir = new int[4];

            rotateDir[target] = dir;
            isRotatable(target, dir);
            rotateGears();
        }

        System.out.print(sumGears());
    }

    // 톱니바퀴 회전
    private static void rotateGears() {
        for (int idx = 0; idx < 4; idx++) {
            if (rotateDir[idx] == 1) { // 시계방향
                int last = gears[idx][7];
                for (int i = 7; i > 0; i--) {
                    gears[idx][i] = gears[idx][i - 1];
                }
                gears[idx][0] = last;
            } else if (rotateDir[idx] == -1) { // 반시계방향
                int first = gears[idx][0];
                for (int i = 0; i < 7; i++) {
                    gears[idx][i] = gears[idx][i + 1];
                }
                gears[idx][7] = first;
            }
        }
    }

    // 회전 할 수 있는지 확인
    private static void isRotatable(int target, int dir) {
        int prev = -dir;
        for (int i = target - 1; i >= 0; i--) {
            if (gears[i][2] != gears[i + 1][6]) {
                rotateDir[i] = prev;
                prev = -prev;
            } else {
                break;
            }
        }

        prev = -dir;
        for (int i = target + 1; i < 4; i++) {
            if (gears[i][6] != gears[i - 1][2]) {
                rotateDir[i] = prev;
                prev = -prev;
            } else {
                break;
            }
        }
    }

    // 12시 방향의 합
    private static int sumGears() {
        int gear1 = gears[0][0] == 1 ? 1 : 0;
        int gear2 = gears[1][0] == 1 ? 2 : 0;
        int gear3 = gears[2][0] == 1 ? 4 : 0;
        int gear4 = gears[3][0] == 1 ? 8 : 0;

        return gear1 + gear2 + gear3 + gear4;
    }

    // 출력 확인용
    private static void print(int[][] arr) {
        for (int[] line : arr) {
            for (int num : line) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}



