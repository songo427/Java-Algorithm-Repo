package sw.expert.academy.d4.exam3289;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 3289. 서로소 집합
 * 송현주
 */
public class Solution3289H {
    private static Edge[] edges;
    private static int N, M;
    private static int[] parents;

    // make set
    private static void makeSet() {
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }

    // find set
    private static int findSet(int x) {
        if (parents[x] == x) return x;
        else return parents[x] = findSet(parents[x]);
    }

    // union
    private static boolean union(int x, int y) {
        if (parents[x] == parents[y]) return false;
        parents[findSet(y)] = findSet(parents[x]);
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringBuilder answer = new StringBuilder("#" + testCase + " ");
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input, " ");

            N = Integer.parseInt(st.nextToken()); // 초기 N개의 집합
            M = Integer.parseInt(st.nextToken()); // 연산의 개수
            edges = new Edge[M];

            for (int i = 0; i < M; i++) {
                input = br.readLine();
                st = new StringTokenizer(input, " ");
                edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            makeSet();
            for (int i = 0; i < M; i++) {
                if (edges[i].type == 1) {
                    answer.append(findSet(edges[i].from) == findSet(edges[i].to) ? 1 : 0);
                } else {
                    union(edges[i].from, edges[i].to);
                }
            }
            System.out.println(answer);
        }
    }
}

class Edge {

    int from, to, type;

    public Edge(int type, int from, int to) {
        this.type = type;
        this.from = from;
        this.to = to;
    }
}
