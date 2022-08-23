package sw.expert.academy.d4.exam3124;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 3124. 최소 스패닝 트리
 * 송현주
 */
public class Solution3124H {
    static List<Edge> edges;
    static int[] parents;
    static int V, E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tesCase = 1; tesCase <= T; tesCase++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
            V = Integer.parseInt(tokenizer.nextToken());
            E = Integer.parseInt(tokenizer.nextToken());
            edges = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                tokenizer = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(tokenizer.nextToken());
                int to = Integer.parseInt(tokenizer.nextToken());
                int weight = Integer.parseInt(tokenizer.nextToken());

                edges.add(new Edge(from, to, weight));
            }

            // weight 기준으로 오름차순 정렬
            Collections.sort(edges);

            makeSet();

            long answer = 0;
            for (int i = 0; i < E; i++) {
                Edge edge = edges.get(i);
                answer += union(edge.from, edge.to) ? (long) edge.weight : 0;
            }
            System.out.println("#" + tesCase + " " + answer);
        }
    }

    private static void makeSet() {
        parents = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parents[i] = i;
        }
    }

    private static int findSet(int x) {
        if (parents[x] == x) return x;
        return parents[x] = findSet(parents[x]);
    }

    private static boolean union(int x, int y) {
        if (findSet(x) == findSet(y)) return false;
        parents[findSet(y)] = findSet(x);
        return true;
    }
}

class Edge implements Comparable<Edge> {

    int from, to, weight;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "from=" + from +
                ", to=" + to +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}
