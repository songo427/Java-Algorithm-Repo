package sw.expert.academy.exam1859;

import java.util.Scanner;

/**
 * 1859. 백만 장자 프로젝트
 * 송현주
 **/

public class Solution1859H {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {

            // 매매가를 알고 있는 기간 N
            int N = sc.nextInt();
            int[] saleList = new int[N];

            for (int i = 0; i < N; i++) {
                saleList[i] = sc.nextInt();
            }

            long sum = 0;
            long maxNum = 0;
            for (int i = N - 1; i >= 0; i--) {
                if(maxNum < saleList[i]){
                    maxNum = saleList[i];
                }else {
                    sum += maxNum - saleList[i];
                }
            }
            System.out.printf("#%d %d %n",test_case, sum);
        }
    }
}

