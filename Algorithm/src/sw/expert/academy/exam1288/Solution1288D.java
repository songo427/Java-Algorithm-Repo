package sw.expert.academy.exam1288;

import java.io.*;

/**
 * 1288. 새로운 불면증 치료법
 * 이다은
 */
public class Solution1288D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(reader.readLine());
            int[] nums = new int[10];
            int idx = 0;

            while (!hasAllNumbers(nums)) {
                idx++;
                String num_str = (N*idx) + "";
                for (char c : num_str.toCharArray()) {
                    nums[Integer.parseInt(c+"")] = 1;
                }
            }

            System.out.println("#" + i + " " + N*idx);
        }
    }

    public static boolean hasAllNumbers(int[] nums) {
        boolean answer = true;
        for (int i : nums) {
            if (i == 0) {
                answer = false;
                break;
            }
        }
        return answer;
    }
}
