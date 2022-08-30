package baekjoon.silver.exam24479;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 24479. 알고리즘 수업 - 깊이 우선 탐색 1
 * 송현주
 * */
public class Solution24479H {

    static int N, order;
    static int[] visitedOrder;
    static List<List<Integer>> graph;
    static StringBuilder answer;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        answer = new StringBuilder();

        N = Integer.parseInt(tokenizer.nextToken().trim()); // 정점의 수
        int M = Integer.parseInt(tokenizer.nextToken().trim()); // 간선의 수
        int start = Integer.parseInt(tokenizer.nextToken().trim()); // 시작 정점

        order = 1;
        graph = new ArrayList<>();
        visitedOrder = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            int from = Integer.parseInt(tokenizer.nextToken().trim());
            int to = Integer.parseInt(tokenizer.nextToken().trim());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        dfs(start);
        setAnswer(visitedOrder);
        System.out.print(answer);
    }

    private static void dfs(int vertex) {

        visitedOrder[vertex] = order;

        Collections.sort(graph.get(vertex));
        for (int next : graph.get(vertex)) {

            if (visitedOrder[next] == 0) {
                order++;
                dfs(next);
            }
        }
    }

    private static void setAnswer(int[] arr) {

        for (int i = 1; i <= N; i++) {
            answer.append(arr[i] + "\n");
        }
    }
}


