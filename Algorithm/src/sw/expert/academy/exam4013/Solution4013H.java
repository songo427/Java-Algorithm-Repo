package sw.expert.academy.exam4013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 4013. [모의 SW 역량테스트] 특이한 자석
 * 송현주
 */

public class Solution4013H {

    static int[][] magnet;

    static int[] dirs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {

            int K = Integer.parseInt(br.readLine()); // 자석 회전 횟수
            magnet = new int[4][8]; // 자석 정보를 저장할 배열

            // 자석 상태 저장
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 8; j++) {
                    magnet[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int target = Integer.parseInt(st.nextToken()) - 1;
                int dir = Integer.parseInt(st.nextToken());
                dirs = new int[4];
                dirs[target] = dir;
                isRotatable(target, dir);
                rotateMagnet();
            }

            answer.append("#").append(testCase).append(" ").append(sum()).append("\n");
        }
        System.out.print(answer.toString().trim());
    }

    private static void rotateMagnet() {

        for (int i = 0; i < 4; i++) {
            // 시계 방향
            if (dirs[i] == 1) {
                int last = magnet[i][7]; // 마지막 값 저장
                for (int j = 7; j > 0; j--) {

                    magnet[i][j] = magnet[i][j - 1];
                }
                magnet[i][0] = last;

            } else if (dirs[i] == -1) { // 반시계 방향
                int first = magnet[i][0]; // 첫번째 값 저장
                for (int j = 0; j < 7; j++) {
                    magnet[i][j] = magnet[i][j + 1];
                }
                magnet[i][7] = first;
            }
        }
    }

    // 회전 여부 - 자석 번호와 방향 전달
    private static void isRotatable(int cur, int dir) {
        int prev = -dir;
        // 앞에 자석 검사
        for (int i = cur; i > 0; i--) {

            // 현재 자석(6)과 앞에 자석(2) 비교 - 다르면 회전
            if (magnet[i][6] != magnet[i - 1][2]) {
                dirs[i - 1] = prev;
                prev = -prev;
            } else {
                break;
            }
        }

        int next = -dir;
        // 뒤에 자석 검사
        for (int i = cur; i < 3; i++) {

            // 현재 자석(2)와 뒤에 자석(6) 비교
            if (magnet[i][2] != magnet[i + 1][6]) {
                dirs[i + 1] = next;
                next = -next;
            } else {
                break;
            }
        }
    }

    // 자석의 합
    private static int sum() {

        int sum = magnet[0][0] == 0 ? 0 : 1;
        sum += magnet[1][0] == 0 ? 0 : 2;
        sum += magnet[2][0] == 0 ? 0 : 4;
        sum += magnet[3][0] == 0 ? 0 : 8;

        return sum;
    }
}
