package sw.expert.academy.d4.exam1486;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 1486. 장훈이의 높은 선반
 * 송현주
 */

public class Solution1486H {
    static Integer[] heights;
    static int N, shelfHeight, minSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            // 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            shelfHeight = Integer.parseInt(st.nextToken());
            minSum = Integer.MAX_VALUE;

            // 점원들의 키 저장
            heights = new Integer[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }

            // 내림차순 정렬
            Arrays.sort(heights, Collections.reverseOrder());

            // 탐색
            dfs(0, 0);
            System.out.println("#" + testCase + " " + (minSum - shelfHeight));
        }

    }

    private static void dfs(int start, int sum) {
        // sum이 shelfHeight보다 같거나 크다면 종료
        // shelfHeight와의 높이를 저장(가장 작은 값으로 갱신)
        if (sum >= shelfHeight) {
            minSum = Math.min(minSum, sum);
            return;
        }

        // 점원의 수를 벗어나면 종료
        if (start >= N) return;


        // 선택
        if (sum + heights[start] < minSum) { // 현재 합 + 다음 점원의 키가 minSum보다 작을 경우에만 탐색
            dfs(start + 1, sum + heights[start]);
        }

        // 선택 안함
        dfs(start + 1, sum);
    }
}
