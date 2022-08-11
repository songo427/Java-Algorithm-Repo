package sw.expert.academy.d2.exam1945;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1945. 간단한 소인수분해
 * 송현주
 */
public class Solution1945H {
    public static void main(String[] args) throws IOException {

        int[] divisors = {2, 3, 5, 7, 11};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringBuilder answer = new StringBuilder("#" + testCase + " ");
            int N = Integer.parseInt(br.readLine().trim());

            int calcResult = N;

            int idx = 0;
            int count = 0;
            while (idx <= divisors.length - 1) {
                if (calcResult % divisors[idx] == 0) {
                    calcResult /= divisors[idx];
                    count++;
                } else {
                    answer.append(count + " ");
                    idx++;
                    count = 0;
                }
            }
            System.out.println(answer);
        }
    }

}
