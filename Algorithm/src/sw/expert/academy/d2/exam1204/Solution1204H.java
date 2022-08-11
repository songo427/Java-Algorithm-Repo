package sw.expert.academy.d2.exam1204;

import java.util.Scanner;

/**
 * 1204. [S/W 문제해결 기본] 1일차 - 최빈수 구하기
 * 송현주
 **/

public class Solution1204H {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();


        for(int test_case = 1; test_case <= T; test_case++)
        {

            int num = sc.nextInt();
            int[] scores = new int[101];

            for(int i=0; i<1000; i++){
                int score = sc.nextInt();
                scores[score] += 1;
            }

            int mostFrequentIdx = -1;
            int mostFrequentScore = -1;
            for(int i=0; i<101; i++){
                if(mostFrequentScore <= scores[i]) {
                    mostFrequentScore = scores[i];
                    mostFrequentIdx = i;
                }
            }

            System.out.printf("#%d %d %n", num, mostFrequentIdx);
        }
    }
}
