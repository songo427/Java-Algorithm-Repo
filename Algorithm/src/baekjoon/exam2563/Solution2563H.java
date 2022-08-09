package baekjoon.exam2563;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2563. 색종이
 * 송현주
 * */
public class Solution2563H {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] paper = new int[100][100];
        int answer =0;

        for(int i=0; i<N; i++){
            String line = br.readLine();
            StringTokenizer input = new StringTokenizer(line," ");
            int x = Integer.parseInt(input.nextToken());
            int y = Integer.parseInt(input.nextToken());

            for(int k=x; k<x+10; k++){
                for(int j=y; j<y+10; j++){
                    paper[k][j] = 1;
                }
            }
        }

        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(paper[i][j]==1) {
                    answer ++;}
            }
        }
        System.out.print(answer);
    }
}
