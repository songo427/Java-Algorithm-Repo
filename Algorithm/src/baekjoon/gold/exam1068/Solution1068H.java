package baekjoon.gold.exam1068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution1068H {

    static int N, target, root, answer;
    static List<List<Integer>> graph;
    static int[] parents;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        root = -1;
        parents = new int[N];

        // index별로 연결 여부 저장
        for (int i = 0; i < N; i++) graph.add(new ArrayList<>());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            int node = Integer.parseInt(st.nextToken());
            if (node == -1) root = i;
            parents[i] = node;
        }

        target = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            if(parents[i] == -1) continue;
            if(i != target) {
                graph.get(parents[i]).add(i);
            }
        }

        answer = 0;

        // 탐색
        dfs(root);
        System.out.println(answer);
    }

    // 탐색
    private static void dfs(int start) {

        if (start == target) return;
        if (graph.get(start).size() == 0) {
            answer++;
            return;
        }

        for (int idx : graph.get(start)) {
            if (idx == target) {
                continue;
            }
            dfs(idx);
        }
    }
}