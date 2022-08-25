package baekjoon.silver.exam15900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 15900. 나무 탈출
 * 송현주
 */
public class Solution15900H {
    static boolean[] visited;
    static List<List<Integer>> graph; // 배열로 하면 메모리 초과
    static int N, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        answer = 0;
        visited = new boolean[N + 1];
        graph = new ArrayList<>();

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        dfs(1, 0);

        // 짝수이면, 성원이가 진 경우
        System.out.print(answer % 2 == 0 ? "No" : "Yes");
    }

    private static void dfs(int vertex, int cnt) {

        if(vertex != 1 && graph.get(vertex).size() == 1){
            answer += cnt;
        }

        visited[vertex] = true;

        for(int i : graph.get(vertex)){
            if(!visited[i]){
                dfs(i, cnt +1);
            }
        }
    }
}
