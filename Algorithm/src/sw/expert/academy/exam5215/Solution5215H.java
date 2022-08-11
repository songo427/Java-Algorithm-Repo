package sw.expert.academy.exam5215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 5215. 햄버거 다이어트
 * 송현주
 * */
public class Solution5215H {
    static int L, N;
    static int[][] calories;
    static int maxScore;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {

            maxScore = 0;
            String line = br.readLine();
            StringTokenizer tokenizer = new StringTokenizer(line);

            N = Integer.parseInt(tokenizer.nextToken()); // 재료의 수
            L = Integer.parseInt(tokenizer.nextToken()); // 제한 칼로리

            calories = new int[N][2];

            for (int i = 0; i < N; i++) {
                line = br.readLine();
                tokenizer = new StringTokenizer(line);
                calories[i][0] = Integer.parseInt(tokenizer.nextToken());
                calories[i][1] = Integer.parseInt(tokenizer.nextToken());
            }
            combination(0, 0, 0);
            System.out.println("#" + testCase + " " + maxScore);
        }
    }

    private static void combination(int currentCalories, int currentScore, int cnt) {

        if (cnt == N) {
            if (maxScore < currentScore) {
                maxScore = currentScore;
            }
            return;
        }

        if (currentCalories + calories[cnt][1] <= L) {
            combination(currentCalories + calories[cnt][1], currentScore + calories[cnt][0], cnt + 1);
        }
        combination(currentCalories, currentScore, cnt + 1);
    }
}