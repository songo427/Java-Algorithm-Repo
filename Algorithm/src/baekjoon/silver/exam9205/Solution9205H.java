package baekjoon.silver.exam9205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 9205. 맥주 마시면서 걸어가기
 * 송현주
 */
public class Solution9205H {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        // testCase
        for (int testCase = 1; testCase <= T; testCase++) {

            // 입력
            N = Integer.parseInt(br.readLine()); // 편의점의 수
            Point[] places = new Point[N + 2];
            graph = new ArrayList<>();
            visited = new boolean[N + 2];

            // 장소 좌표 저장
            for (int i = 0; i < N + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                places[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                graph.add(new ArrayList<>());
            }

            // 연결 정보 저장
            for (int i = 0; i < N + 2; i++) {
                for (int j = i + 1; j < N + 2; j++) {
                    if (findDistance(places[i], places[j]) <= 1000) {
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
                }
            }

            // 탐색
            answer.append(bfs() ? "happy" : "sad").append("\n");
        }
        System.out.print(answer);

    }

    // 탐색
    private static boolean bfs() {

        Queue<Integer> queue = new ArrayDeque<>();

        // 집부터 시작
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 현재 지점이 페스티벌이라면 true
            if (current == N + 1) {
                return true;
            }

            for (int next : graph.get(current)) {

                // 이미 갔던 장소라면 continue
                if (visited[next]) continue;

                // 방문
                visited[next] = true;
                queue.add(next);
            }
        }

        // 갈 수 있는 길이 없다면 false
        return false;
    }

    // 거리 구하는 메서드
    private static int findDistance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
}
