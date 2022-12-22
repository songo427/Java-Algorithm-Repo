package baekjoon.gold.exam15591;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution15591H {

    // 동영상 들 간 Usado 정보 저장
    static class Usado {
        int q, r;

        public Usado(int q, int r) {
            this.q = q;
            this.r = r;
        }
    }

    static int N, Q;
    static ArrayList<Usado>[] usages;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        N = Integer.parseInt(st.nextToken()); // 동영상 수
        Q = Integer.parseInt(st.nextToken()); // 존의 질문 수

        usages = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) usages[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            usages[p].add(new Usado(q, r));
            usages[q].add(new Usado(p, r));
        }


        for (int i = 0; i < Q; i++) {
            visited = new boolean[N + 1];
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            answer.append(bfs(k, v)).append('\n');
        }

        System.out.println(answer.toString().trim());
    }

    // bfs 탐색으로 질문에 대한 답변 구하기
    private static int bfs(int k, int v) {
        int count = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(v);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (Usado nextUsado : usages[current]) {
                if (!visited[nextUsado.q] && nextUsado.q != v && k <= nextUsado.r) {
                    queue.add(nextUsado.q);
                    visited[nextUsado.q] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
