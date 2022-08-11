package sw.expert.academy.d2.exam1285;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1285. 아름이의 돌던지기 D2
 * 송현주
 **/

public class Solution1285H {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int testCase = 1; testCase <= T; testCase++){

            int N = sc.nextInt();
            int[] scores = new int[N];
            int count = 0;
            for(int i=0; i<N; i++){
                scores[i] = Math.abs(sc.nextInt());
            }

            Arrays.sort(scores);

            int minScore = scores[0];
            for(int i=0; i<N; i++){
                if(minScore == scores[i]){
                    count ++;
                }else{
                    break;
                }
            }
            System.out.printf("#%d %d %d %n", testCase, minScore, count);
        }
    }
}
