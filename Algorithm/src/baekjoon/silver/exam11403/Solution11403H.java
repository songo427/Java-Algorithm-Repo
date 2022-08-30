package baekjoon.silver.exam11403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 11403. 경로 찾기
 * 송현주
 */
public class Solution11403H {

    static int[][] graph;
    static boolean visited[][];
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(tokenizer.nextToken());
        graph = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        floyd();
        print(graph);
    }

    private static void floyd() {
        // k는 거쳐가는 정점
        for (int k = 0; k < N; k++) {
            // i는 시작 정점
            for (int i = 0; i < N; i++) {
                // j는 도착 정점
                for (int j = 0; j < N; j++) {

                    // 시작점~경유지까지 갈 수 있고, 경유지에서 도착점까지 갈 수 있다면
                    if (graph[i][k] == 1 && graph[k][j] == 1) {

                        // 인접 행렬 1로
                        graph[i][j] = 1;
                    }
                }
            }
        }
    }

    private static void print(int[][] arr) {
        for (int[] line : arr) {
            for (int num : line) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
