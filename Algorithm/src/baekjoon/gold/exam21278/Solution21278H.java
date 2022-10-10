package baekjoon.gold.exam21278;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 21278. 호석이 두 마리 치킨
 * 송현주
 */
public class Solution21278H {
    static int N, minDistance = Integer.MAX_VALUE;
    final static int INF = 9999;
    static int[][] dist;
    static int[] combNums;

    static int[] minBuildings;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 건물의 수
        int M = Integer.parseInt(st.nextToken()); // 도로의 수

        // 생성
        dist = new int[N + 1][N + 1];

        // INF 값으로 초기화
        for (int[] line : dist) Arrays.fill(line, INF);

        // 연결된 건물 정보는 갱신
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int b1 = Integer.parseInt(st.nextToken());
            int b2 = Integer.parseInt(st.nextToken());
            dist[b1][b2] = 1;
            dist[b2][b1] = 1;
        }

        // 연결 정보 갱신
        floyd();

        // 조합에 따라 계산
        combNums = new int[2];
        minBuildings = new int[2];
        comb(1, 0);
        System.out.print(minBuildings[0] + " " + minBuildings[1] + " " + minDistance);
    }

    // floyd
    private static void floyd() {
        // k(경유지) - i(출발지) - j(도착지)
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {

                    if (i == k || j == k) continue;

                    // 같은 빌딩이라면 거리 0
                    if (i == j) {
                        dist[i][j] = 0;
                        continue;
                    }

                    // 거리 갱신
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }


    // 조합을 구하기 위한 메서드
    private static void comb(int start, int cnt) {
        // 두 개의 건물을 뽑아 조합
        if (cnt == 2) {
            int result = calcDistance(combNums[0], combNums[1]);
            if (minDistance > result) {
                minDistance = result;
                minBuildings[0] = combNums[0];
                minBuildings[1] = combNums[1];
            }
            return;
        }

        for (int i = start; i <= N; i++) {
            combNums[cnt] = i;
            comb(i + 1, cnt + 1);
        }
    }

    // 거리를 계산하기 위한 메서드
    private static int calcDistance(int b1, int b2) {
        // 거리
        int distance = 0;
        for (int i = 1; i <= N; i++) {

            // 자기자신은 생략
            if (b1 == i || b2 == i) continue;

            // 더 작은 값으로 갱신
            distance += Math.min(dist[b1][i], dist[b2][i]);
        }

        // 왕복임으로 2배
        return distance * 2;
    }
}
