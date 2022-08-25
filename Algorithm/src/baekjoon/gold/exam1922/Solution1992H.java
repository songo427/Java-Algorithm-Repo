package baekjoon.gold.exam1922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1992. 네트워크
 * 송현주
 */
public class Solution1992H {

    static class Edge implements Comparable<Edge> {

        int from, to, weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Point(" +
                    from +
                    ", " + to +
                    ") weight=" + weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    // 변수
    static int N, M, answer;
    static List<Edge> edges;

    static int[] parents;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 정점의 수
        M = Integer.parseInt(br.readLine()); // 간선의 수
        edges = new ArrayList<>();
        answer = 0;
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            edges.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        // 정렬
        Collections.sort(edges);

        makeSet();
        for (Edge e : edges) {
            answer += union(e.from, e.to) ? e.weight : 0;
        }
        System.out.println(answer);
    }


    private static void makeSet() {
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }

    private static int findSet(int x) {
        if (x == parents[x]) return x;
        return parents[x] = findSet(parents[x]);
    }

    private static boolean union(int x, int y) {
        if (parents[findSet(y)] == parents[findSet(x)]) return false;
        parents[findSet(y)] = parents[findSet(x)];
        return true;
    }
}
