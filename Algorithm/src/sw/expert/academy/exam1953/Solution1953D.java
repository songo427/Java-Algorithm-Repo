package sw.expert.academy.exam1953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1953. 탈주범 검거
 * 이다은
 */
public class Solution1953D {
    static int[][] tunnel;
    static boolean[][] visited;
    static int[][] pipeType = {{0, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 1, 0, 0},
            {0, 0, 1, 1},
            {1, 0, 0, 1},
            {0, 1, 0, 1},
            {0, 1, 1, 0},
            {1, 0, 1, 0}};
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            tunnel = new int[N][M];
            visited = new boolean[N][M];

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(reader.readLine());
                for (int k = 0; k < M; k++) {
                    tunnel[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println("#" + i + " " + bfs(R, C, L));

        }

    }

    public static int bfs(int currentR, int currentC, int L) {
        int time = 1;
        int answer = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(currentR, currentC));
//        visited[currentR][currentC] = true;


        while (!queue.isEmpty()) {
            if (time == L) {
                break;
            }

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                int r = node.r;
                int c = node.c;
                if (!visited[r][c]) {
                    visited[r][c] = true;

//                if (tunnel[r][c] != 0) {
////                    System.out.println(tunnel[r][c]);
//                    answer++;
//                }

                    int[] ways = pipeType[tunnel[r][c]];
                    for (int j = 0; j < ways.length; j++) {
                        if (ways[j] == 1) {
                            int ny = r + dy[j];
                            int nx = c + dx[j];

//                            System.out.println(ny + " " + nx);
                            if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                                continue;
                            }

                            if (visited[ny][nx]) {
                                continue;
                            }

                            int check;
                            if (j%2 == 0) {
                                check = pipeType[tunnel[ny][nx]][j+1];
                            } else {
                                check = pipeType[tunnel[ny][nx]][j-1];
                            }

                            if (check == 1) {
//                                System.out.println(r + " " + c + " " + ny + " " +  nx + " " + tunnel[ny][nx]);
                                queue.offer(new Node(ny, nx));
                                answer++;
                            }

                        }
                    }


                }
            }

            time++;

        }

        return answer;
    }

    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
