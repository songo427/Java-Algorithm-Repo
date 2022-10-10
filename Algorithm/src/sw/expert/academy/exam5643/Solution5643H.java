package sw.expert.academy.exam5643;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 5643. [Professional] 키 순서
 * 송현주
 */
public class Solution5643H {

    static int N;
    static int[][] dist;
    final static int INF = 9999;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 전체 테스트케이스 수

        // 입력
        for (int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine()); // 학생의 수
            int M = Integer.parseInt(br.readLine()); // 학생의 수를 비교한 횟수

            answer.append("#").append(testCase).append(" ");

            // 정보 저장
            dist = new int[N + 1][N + 1];
            // 무한으로 초기화
            for (int[] line : dist) Arrays.fill(line, INF);

            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                dist[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }


            floyd();
            answer.append(findAnswer()).append("\n");
        }

        System.out.print(answer.toString().trim());

    }

    private static void floyd() {
        // 경유지(k) -> 출발지(i) -> 도착지(j)
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j) continue;
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }

    private static int findAnswer() {
        int stCnt = 0;
        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (int j = 1; j <= N; j++) {
                if (dist[i][j] != INF || dist[j][i] != INF) count++;
            }
            if (count == N - 1) stCnt++;
        }
        return stCnt;
    }

    private static void print(int[][] arr) {
        for (int[] line : arr) {
            for (int num : line) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }
}
