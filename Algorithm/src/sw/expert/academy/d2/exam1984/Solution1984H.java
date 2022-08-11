package sw.expert.academy.d2.exam1984;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1984. 중간 평균값 구하기
 * 송현주
 */

public class Solution1984H {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int sum = 0;
            int[] numArr = new int[10];

            // 저장
            for(int i=0; i<10; i++){
                numArr[i] = sc.nextInt();
            }

            // 정렬
            Arrays.sort(numArr);

            // 출력
            for(int i=1; i<9; i++){
                sum += numArr[i];
            }
            System.out.printf("#%d %d %n", test_case, sum/8);
        }
    }
}