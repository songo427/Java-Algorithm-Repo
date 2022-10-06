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
    static boolean answer;

    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer tokenizer = new StringTokenizer(input, " ");
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        friends = new ArrayList<>();

        // 사람 수만큼 생성
        for (int i = 0; i < N; i++) {
            friends.add(new ArrayList<>());
        }

        // 친구 관계 저장
        for (int i = 0; i < M; i++) {
            input = br.readLine();
            tokenizer = new StringTokenizer(input, " ");
            int friendA = Integer.parseInt(tokenizer.nextToken());
            int friendB = Integer.parseInt(tokenizer.nextToken());

            // 서로 친구 관계
            friends.get(friendA).add(friendB);
            friends.get(friendB).add(friendA);
        }

        // 모든 범위 탐색
        for (int i = 0; i < N; i++) {
            if(answer) break;
            visited = new boolean[N];
            dfs(i, 0);
        }
        System.out.println(answer? 1 : 0);
    }

    // dfs 탐색
    private static void dfs(int current, int cnt) {

        if (cnt == 4) {
            answer = true;
            return;
        }

        visited[current] = true;

        for (int v : friends.get(current)) {
            if (visited[v]) continue;
            dfs(v, cnt + 1);
        }
        visited[current] = false;
    }
}

