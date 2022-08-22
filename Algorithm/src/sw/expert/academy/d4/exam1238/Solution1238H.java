package sw.expert.academy.d4.exam1238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1238. [S/W 문제해결 기본] 10일차 - Contact
 * 송현주
 */

public class Solution1238H {

    static int[][] contact;
    static int[] contactDepth;

    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int testCase = 1; testCase <= 1; testCase++) {

            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

            // 입력
            int N = Integer.parseInt(tokenizer.nextToken()); // 입력 개수
            int start = Integer.parseInt(tokenizer.nextToken()); // 시작 위치
            contactDepth = new int[101];

            // 연결 관계
            contact = new int[101][101];
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N / 2; i++) {
                int from = Integer.parseInt(tokenizer.nextToken());
                int to = Integer.parseInt(tokenizer.nextToken());
                contact[from][to] = 1;

            }

            answer = 0;
            bfs(start);

            // 최대 깊이 찾기
            int maxDepth = 0;
            for (int i = 1; i < 101; i++) {
                if (maxDepth <= contactDepth[i]) {
                    maxDepth = contactDepth[i];
                    answer = i;
                }
            }

            // 출력
            System.out.println("# " + testCase + " " + answer);
        }
    }

    private static void bfs(int v) {

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(v);

        while (!queue.isEmpty()) {

            int current = queue.poll();

            // 1부터 100이하까지
            for (int i = 1; i < 101; i++) {
                if (contactDepth[i] == 0 && contact[current][i] == 1) {
                    contactDepth[i] = contactDepth[current] + 1; // 부모 depth + 1
                    queue.add(i);
                }
            }
        }
    }
}