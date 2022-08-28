//package baekjoon.gold.exam4485;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
///**
// * 4485. 녹색 옷 입은 애가 젤다지?
// * 송현주
// */
//
//public class Solution4485H {
//
//    // 상 - 하 - 좌 - 우
//    static int[] dx = {-1, 1, 0, 0};
//    static int[] dy = {0, 0, -1, 1};
//    static int[][] cave;
//    static int[][] D;
//    static boolean[][] visited;
//    static boolean[] isVisited;
//    static int N, answer;
//
//    static int start, end;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input;
//        int testCase = 1;
//        while (true) {
//
//            input = br.readLine();
//
//            // 0을 만날 때까지 입력 받기
//            if (input.equals("0")) {
//                break;
//            }
//
//            // 동굴의 크기 N
//            N = Integer.parseInt(input);
//            cave = new int[N][N];
//            visited = new boolean[N][N];
//            isVisited = new boolean[N];
//            answer = Integer.MAX_VALUE;
//            D = new int[N][N];
//            Arrays.fill(D, Integer.MAX_VALUE);
//            start = 0;
//            end = N - 1;
//
//            // 배열 입력
//            for (int i = 0; i < N; i++) {
//                input = br.readLine();
//                StringTokenizer st = new StringTokenizer(input, " ");
//                for (int j = 0; j < N; j++) {
//                    cave[i][j] = Integer.parseInt(st.nextToken());
//                }
//            }
//            //dfs(0, 0, cave[0][0]);
//            D[start][start] = cave[0][0];
//            go();
//            System.out.println("Problem " + testCase + ": " + answer);
//            testCase++;
//        }
//    }
//
//    private static void go() {
//
//        int minCost = Integer.MAX_VALUE;
//        int minVertex = -1;
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(D));
//            // step 1. 미방문 정점 중 출발지에서 자신으로의 비용이 최소인 정점 선택
//            for (int j = 0; j < N; j++) {
//                if (!isVisited[j] && minCost > D[j]) {
//                    minCost = D[j];
//                    minVertex = j;
//                }
//            }
//
//            // step 2. 방문 처리
//            isVisited[minVertex] = true;
//            if (minVertex == end) {
//                break;
//            }
//
//            // step3. 선택된 정점을 경유지로 해서 미방문 정점들로 가는 비용을 따져보고
//            // 기존 최적해보다 유리하면 갱신
//            for (int j = 0; j < N; j++) {
//                if (!isVisited[j] && D[j] > D[minVertex] + cave[minVertex][j]){
//                    D[j] = D[minVertex] + cave[minVertex][j];
//                    System.out.println("갱신됨 ! D["+j+"] = "+D[j]);
//
//                }
//            }
//        }
//    }
//
//    private static void dfs(int x, int y, int cost) {
//
//        // 마지막 위치에 도달했다면 break;
//        if (x == N - 1 && y == N - 1) {
//            if (answer > cost) {
//                answer = cost;
//            }
//            return;
//        }
//
//        for (int i = 0; i < 4; i++) {
//
//            int nx = x + dx[i];
//            int ny = y + dy[i];
//
//            // 방문하지 않았고, 갈 수 있다면
//            if (isIn(nx, ny) && !visited[nx][ny]) {
//
//                if (cost + cave[nx][ny] <= answer) {
//                    visited[nx][ny] = true;
//                    dfs(nx, ny, cost + cave[nx][ny]);
//                    visited[nx][ny] = false;
//                }
//
//            }
//        }
//    }
//
//    private static void bfs(int x, int y){
//
//
//    }
//
//
//    private static boolean isIn(int nx, int ny) {
//        return nx >= 0 && ny >= 0 && nx < N && ny < N;
//    }
//}
