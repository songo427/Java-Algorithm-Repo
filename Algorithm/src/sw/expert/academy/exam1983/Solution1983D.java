package sw.expert.academy.exam1983;

import java.io.*;
import java.util.*;

/**
 * 1983. 조교의 성적 매기기
 * 이다은
 */
public class Solution1983D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        String[] grades = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            ArrayList<Double> scoreList = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(reader.readLine(), " ");
                double score = Integer.parseInt(st.nextToken()) * 0.35 + Integer.parseInt(st.nextToken()) * 0.45 + Integer.parseInt(st.nextToken()) * 0.2;
                scoreList.add(score);
            }
            double score = scoreList.get(K-1);
            scoreList.sort(Comparator.reverseOrder());

            System.out.println("#" + i + " " + grades[scoreList.indexOf(score) / (N/10)]);

        }
    }
}
