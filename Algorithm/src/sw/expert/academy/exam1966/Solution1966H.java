package sw.expert.academy.exam1966;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1966. 숫자를 정렬하자
 * 송현주
 */

public class Solution1966H {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer;
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            answer = new StringBuilder("#" + testCase + " ");
            int N = Integer.parseInt(br.readLine());

            String line = br.readLine();
            StringTokenizer tokenizer = new StringTokenizer(line);
            List<Integer> nums = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                nums.add(Integer.parseInt(tokenizer.nextToken()));
            }

            Collections.sort(nums);

            for (int num : nums) {
                answer.append(num + " ");
            }

            System.out.println(answer);
        }
    }
}

