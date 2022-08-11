package sw.expert.academy.d2.exam1288;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1288. 새로운 불면증 치료법
 * 송현주
 */

public class Solution1288H {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {

            String numCase = "0123456789";
            String N = br.readLine();
            String cnt = N;
            int idx = 1;

            while (true) {
                String[] nums = numCase.split("");
                for (int i = 0; i < nums.length; i++) {
                    if (cnt.contains(nums[i])) {
                        numCase = numCase.replace(nums[i], "");
                    }
                }
                if (numCase.length() == 0) break;
                idx++;
                cnt = String.valueOf((Integer.parseInt(N) * idx));
            }
            System.out.println("#" + testCase + " " + cnt);
        }
    }
}
