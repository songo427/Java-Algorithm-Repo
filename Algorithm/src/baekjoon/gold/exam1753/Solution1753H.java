package baekjoon.gold.exam1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1753. 최단거리
 * 송현주
 */

public class Solution1753H {

    static class Node {
        int next;
        int cost;

        public Node(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }

    static int V, I, start;
    static int[] dist;
    static List<List<Node>> graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        V = Integer.parseInt(st.nextToken());
        I = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        dist = new int[V + 1];
        graph = new ArrayList<>();

        // 최댓값으로 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 저장 공간 생성
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        // 거리 초기값 갱신
        for (int i = 0; i < I; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e, val));
        }

        // 시작점 자신은 0으로 출력
        dist[start] = 0;

        // 거리 비용 갱신
        updateCost(start);

        // 출력
        for (int i = 1; i <= V; i++) {
            answer.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append("\n");
        }
        System.out.println(answer);
    }

    private static void updateCost(int start) {

        PriorityQueue<Node> queue = new PriorityQueue<Node>((n1, n2) -> n1.cost - n2.cost);
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            // 현재 노드
            Node cur = queue.poll();

            // 현재 노드와 연결된 노드들을 가져옴
            for (Node node : graph.get(cur.next)) {

                // 갱신이 필요한 경우
                if (dist[cur.next] + node.cost < dist[node.next]) {
                    dist[node.next] = dist[cur.next] + node.cost;
                    queue.add(new Node(node.next, dist[node.next]));
                }
            }
        }
    }
}
