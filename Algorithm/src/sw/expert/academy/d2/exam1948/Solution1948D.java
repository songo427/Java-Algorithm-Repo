package sw.expert.academy.d2.exam1948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1948. 날짜 계산기
 * 이다은
 */
public class Solution1948D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            int m1 = Integer.parseInt(st.nextToken());
            int d1 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());
            int d2 = Integer.parseInt(st.nextToken());
            
            int answer;
            if (m1 == m2) {
                answer = d2 - d1 + 1;
            } else {
                answer = days[m1-1] - d1 + 1;
                for (int j = m1; j < m2-1; j++) {
                    answer += days[j];
                }
                answer += d2;
            }

            System.out.println("#" + i + " " + answer);

        }
    }
}
