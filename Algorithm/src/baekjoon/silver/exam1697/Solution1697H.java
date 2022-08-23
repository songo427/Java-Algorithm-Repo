package baekjoon.silver.exam1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1697. 숨바꼭질
 * 송현주
 */

public class Solution1697H {

    static int N, K;
    static int[] numbers;
    static boolean[] visited;

    static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer tokenizer = new StringTokenizer(input);

        N = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());
        numbers = new int[100001];
        visited = new boolean[100001];
        queue = new ArrayDeque<>();
        bfs(N, 0);
    }

    private static void bfs(int v, int cnt) {

        while (!queue.isEmpty()) {

            if (K == v) {
                System.out.println(cnt);
                return;
            }

            queue.add(v - 1);
            queue.add(v + 1);
            queue.add(v * 2);

            int current = queue.poll();
            if(current >= 0 && current <= K){
                bfs(current, cnt + 1);
            }
        }
    }
}
