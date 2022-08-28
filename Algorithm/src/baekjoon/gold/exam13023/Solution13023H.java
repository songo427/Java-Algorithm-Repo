package baekjoon.gold.exam13023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution13023H {

    static int N, M;
    static List<List<Integer>> friends;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer tokenizer = new StringTokenizer(input, " ");
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        // 친구 수만큼
//        friends = new int[N][N];
        friends = new ArrayList<>();
        visited = new boolean[N];

        for (int i = 0; i < M; i++) {
            input = br.readLine();
            tokenizer = new StringTokenizer(input, " ");
            int friendA = Integer.parseInt(tokenizer.nextToken());
            int friendB = Integer.parseInt(tokenizer.nextToken());

        }

        int answer = 0;
        if (dfs(0, 0)) {
            answer = 1;
        }
        System.out.print(answer);
    }

    private static boolean dfs(int v, int cnt) {

        if (cnt == 4) {
            return true;
        }
        visited[v] = true;
        for (int i = 0; i < N; i++) {
        }
        visited[v] = false;
        return false;
    }
}

